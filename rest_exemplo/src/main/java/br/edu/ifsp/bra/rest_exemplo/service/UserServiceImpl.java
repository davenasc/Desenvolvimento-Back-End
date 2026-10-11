package br.edu.ifsp.bra.rest_exemplo.service;

import java.util.ArrayList;

import br.edu.ifsp.bra.rest_exemplo.model.User;

public class UserServiceImpl implements UserService {
    private ArrayList<User> database;

    public UserServiceImpl(){
        database = new ArrayList<>();
    }

    @Override
    public void add(user newUser){
        database.add(newUser);
    }


    
}
