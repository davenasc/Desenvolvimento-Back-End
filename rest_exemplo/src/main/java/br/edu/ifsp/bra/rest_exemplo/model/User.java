package br.edu.ifsp.bra.rest_exemplo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
   private String login;
   private String senha; 
}
