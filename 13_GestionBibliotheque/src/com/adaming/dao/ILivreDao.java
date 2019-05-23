package com.adaming.dao;

import java.util.ArrayList;

import com.adaming.model.Livre;

public interface ILivreDao {

	public ArrayList<Livre> afficherTout ();
	public boolean deleteLivre (Livre l);
	public boolean modifierLivre (Livre l);
	public boolean ajouterLivre (Livre l);
}
