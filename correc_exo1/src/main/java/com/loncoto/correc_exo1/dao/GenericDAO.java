package com.loncoto.correc_exo1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.correc_exo1.metier.IGenericEntity;

public class GenericDAO<T extends IGenericEntity> {
	
	@PersistenceContext
	private EntityManager em;
	private Class<T> entityType;
	
	
	public GenericDAO(Class entityType) {
		this.entityType = entityType;
	}
	
	
	// renvoie la liste des entite de type T
	@Transactional
	public List<T> findAll() {
		return em.createQuery("from " + entityType.getSimpleName(), entityType)
				 .getResultList();
	}
	
	// recupere une entite de type T
	@Transactional
	public T findByID(int id) {
		return em.find(entityType, id);
	}
	
	@Transactional
	public T save(T entity) {
		if (entity.fetchPrimaryKey() == 0) {
			em.persist(entity);
		}
		else
		{
			entity = em.merge(entity);
		}
		return entity;
	}

	@Transactional
	public T remove(int id) {
		T entity = em.find(entityType, id);
		if (entity != null)
			em.remove(entity);
		return entity;
	}
}
