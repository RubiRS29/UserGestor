package com.AppGestorUser.GestorUser.dao;

import com.AppGestorUser.GestorUser.models.Usuario;


import java.util.List;


public interface IUserDao {
    List<Usuario> getUsers();



    Usuario getUserById(Long id);

    void deleteUserById(Long id);

    void register(Usuario usuario);

    Usuario GetUserByEmailPassword(Usuario user);
}
