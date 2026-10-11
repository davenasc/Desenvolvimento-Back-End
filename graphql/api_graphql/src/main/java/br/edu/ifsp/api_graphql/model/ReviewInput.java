package br.edu.ifsp.api_graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewInput {
    private Integer stars;
    private String commentary;
}
