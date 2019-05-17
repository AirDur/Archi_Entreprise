package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Users;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void register(Users u) {
        entityManager.persist(u);
    }
}
