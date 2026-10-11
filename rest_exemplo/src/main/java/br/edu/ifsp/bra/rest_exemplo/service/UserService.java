package br.edu.ifsp.bra.rest_exemplo.service;

import br.edu.ifsp.bra.rest_exemplo.model.User;

public interface UserService {
    public void add(User newUser);
    public User find(String login);
    public User update(User updateUser);
    public boolean remove(String login);

}
