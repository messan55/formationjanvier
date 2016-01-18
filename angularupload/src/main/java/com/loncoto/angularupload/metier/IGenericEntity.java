package com.loncoto.angularupload.metier;

public interface IGenericEntity {
	// cette methode sera fournie par l'entite concrete
	// et renverra sa clé primaire
	int fetchPrimaryKey();
}
