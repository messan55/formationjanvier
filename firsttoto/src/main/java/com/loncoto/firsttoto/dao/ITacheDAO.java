package com.loncoto.firsttoto.dao;

import java.util.List;

import com.loncoto.firsttoto.metier.Tache;

public interface ITacheDAO {
	List<Tache> findAll();
	Tache findByID(int id);
	
}
