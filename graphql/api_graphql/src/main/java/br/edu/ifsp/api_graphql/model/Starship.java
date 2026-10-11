package br.edu.ifsp.api_graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Starship {
    private String id;
    private String name;
    private Float length;
}
