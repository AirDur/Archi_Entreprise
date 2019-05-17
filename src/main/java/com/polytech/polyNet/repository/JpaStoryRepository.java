package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Story;
import org.springframework.transaction.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        String requeteFindStory = "SELECT s FROM Story s";
        Query query = entityManager.createQuery(requeteFindStory);
        return query.getResultList();
    }

    @Override
    public List getComment(Story s) {
        Query query = entityManager.createQuery("SELECT c FROM Comment c WHERE story_id= " + s.getId());
        return query.getResultList();
    }

    @Override
    public Story getStory(Story id) {
        Query query = entityManager.createQuery("SELECT s FROM Story s WHERE id = " + id.getId());
        return (Story) query.getResultList().get(0);
    }
}
