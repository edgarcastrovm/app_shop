package com.shop.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AuxRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Object[]> execQuery(String sql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null) {
            params.forEach(query::setParameter);
        }
        return query.getResultList();
    }

}
