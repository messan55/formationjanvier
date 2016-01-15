package com.loncoto.correc_exo1.dao;

import com.loncoto.correc_exo1.metier.Produit;

public class ProduitDAO extends GenericDAO<Produit>  implements IProduitDAO{

	public ProduitDAO() {
		super(Produit.class);
	}

}
