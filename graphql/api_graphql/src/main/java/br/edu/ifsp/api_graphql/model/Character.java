package br.edu.ifsp.api_graphql.model;

import java.util.List;

public interface Character {
    String getId();
    String getName();
    List<Episode> getAppearsIn();
    List<Character> getFriends();
}
