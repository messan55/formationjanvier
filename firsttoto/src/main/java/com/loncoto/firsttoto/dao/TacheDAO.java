package com.loncoto.firsttoto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.loncoto.firsttoto.metier.Tache;


public class TacheDAO implements ITacheDAO {

	private static Logger log = LogManager.getLogger(TacheDAO.class);
	
	public TacheDAO() {
		log.info("construction dao tache");
	}
	
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}

	@Transactional
	@Override
	public List<Tache> findAll() {
		return em.createQuery("from Tache", Tache.class).getResultList();
	}

	@Transactional
	@Override
	public Tache findByID(int id) {
		return em.find(Tache.class, id);
	}

}
