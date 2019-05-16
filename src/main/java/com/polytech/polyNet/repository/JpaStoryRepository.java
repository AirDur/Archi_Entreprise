package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Story;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaStoryRepository implements StoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Story s) {
        entityManager.persist(s);
    }

    @Override
    public List findAll() {
        Query query = entityManager.createQuery("SELECT * FROM Story");
        return query.getResultList();
    }

    @Override
    public List getComment(Story s) {
        Query query = entityManager.createQuery("SELECT * FROM Comment WHERE story_d= " + s.getId());
        return query.getResultList();
    }

    @Override
    public Story getStory(Story id) {
        Query query = entityManager.createQuery("SELECT * FROM Story WHERE s.id = " + id.getId());
        return (Story) query.getResultList().get(0);
    }
}
