package br.edu.ifsp.api_graphql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.api_graphql.model.Character;
import br.edu.ifsp.api_graphql.model.Droid;
import br.edu.ifsp.api_graphql.model.Episode;
import br.edu.ifsp.api_graphql.model.Human;
import br.edu.ifsp.api_graphql.model.Review;
import br.edu.ifsp.api_graphql.model.ReviewInput;
import br.edu.ifsp.api_graphql.model.Starship;

@Controller
public class StarWarController {

    private final List<Human> humans = new ArrayList<>(List.of(
        new Human("1001", "Luke Skywalker", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), new ArrayList<>(), 1.72f),
        new Human("1002", "Darth Vader", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), new ArrayList<>(), 2.02f)
    ));

    private final List<Droid> droids = new ArrayList<>(List.of(
        new Droid("2001", "R2-D2", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), new ArrayList<>(), "Astromech"),
        new Droid("2002", "C-3PO", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), new ArrayList<>(), "Protocol")
    ));

    private final List<Starship> starships = new ArrayList<>(List.of(
        new Starship("3000", "Millennium Falcon", 34.37f),
        new Starship("3001", "X-Wing", 12.5f)
    ));

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return humans.get(0);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droids.stream()
            .filter(d -> d.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        List<Object> results = new ArrayList<>();
        humans.stream().filter(h -> h.getName().toLowerCase().contains(text.toLowerCase())).forEach(results::add);
        droids.stream().filter(d -> d.getName().toLowerCase().contains(text.toLowerCase())).forEach(results::add);
        starships.stream().filter(s -> s.getName().toLowerCase().contains(text.toLowerCase())).forEach(results::add);
        return results;
    }

    @QueryMapping
    public List<Human> humans() {
        return humans;
    }

    @QueryMapping
    public List<Starship> starships() {
        return starships;
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return Stream.concat(humans.stream(), droids.stream())
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Float height) {
        Human human = new Human(id, name, List.of(Episode.NEWHOPE), new ArrayList<>(), height);
        humans.add(human);
        return human;
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        Droid droid = new Droid(id, name, List.of(Episode.NEWHOPE), new ArrayList<>(), primaryFunction);
        droids.add(droid);
        return droid;
    }

    @MutationMapping
    public Starship createStarship(@Argument String id, @Argument String name, @Argument Float length) {
        Starship starship = new Starship(id, name, length);
        starships.add(starship);
        return starship;
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        Character character = character(characterId);
        Character friend = character(friendId);

        if (character != null && friend != null) {
            character.getFriends().add(friend);
        }
        return character;
    }
}
