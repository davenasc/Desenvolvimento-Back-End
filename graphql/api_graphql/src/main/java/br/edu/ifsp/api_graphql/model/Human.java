package br.edu.ifsp.api_graphql.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human implements Character {
    private String id;
    private String name;
    private List<Episode> appearsIn = new ArrayList<>();
    private List<Character> friends = new ArrayList<>();
    private Float height;
}
