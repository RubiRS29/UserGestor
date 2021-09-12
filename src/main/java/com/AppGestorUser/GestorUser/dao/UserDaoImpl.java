package com.AppGestorUser.GestorUser.dao;

import com.AppGestorUser.GestorUser.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsers() {
        String query = "from Usuario";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteUserById(Long id) {
        Usuario user = entityManager.find(Usuario.class, id);
        entityManager.remove(user);
    }

    @Override
    public Usuario getUserById(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void register(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario GetUserByEmailPassword(Usuario user) {

        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> listUser = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if (listUser.isEmpty()){
            return null;
        }
        String passwordHash = listUser.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHash, user.getPassword())){
            return listUser.get(0);
        }
        return null;
    }
}
