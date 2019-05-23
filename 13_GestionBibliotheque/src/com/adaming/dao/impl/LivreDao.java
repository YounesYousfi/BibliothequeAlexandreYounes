package com.adaming.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.adaming.dao.ILivreDao;
import com.adaming.model.Livre;
import com.adaming.util.ConnexionDB;

public class LivreDao implements ILivreDao {

	private static Connection con;
	private static PreparedStatement ps;
	
	
	public LivreDao() {
		try {
			con = ConnexionDB.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Livre> afficherTout() {
		try {
			String requete = "SELECT * FROM livres;";
			ps = con.prepareStatement(requete);
			ResultSet rs = ps.executeQuery();
			ArrayList<Livre> listeLivres = new ArrayList<Livre>();
			while (rs.next()) {
				Livre l = new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"),rs.getFloat("prix"));
				listeLivres.add(l);
			}
			return listeLivres;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteLivre(Livre l) {
		try {
			String requete = "delete from livres WHERE id=?;";
			ps = con.prepareStatement(requete);
			ps.setInt(1, l.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean modifierLivre(Livre l) {
		try {
			String requete = "update livres set titre=?,auteur=?,prix=? WHERE id=?;";
			ps = con.prepareStatement(requete);
			ps.setString(1, l.getTitre());
			ps.setString(2, l.getAuteur());
			ps.setFloat(3, l.getPrix());
			ps.setInt(4, l.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean ajouterLivre(Livre l) {
		try {
			System.out.println("test");
			String requete = "insert into livres (titre,auteur,prix) values (?,?,?);";
			ps = con.prepareStatement(requete);
			ps.setString(1, l.getTitre());
			ps.setString(2, l.getAuteur());
			ps.setFloat(3, l.getPrix());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
