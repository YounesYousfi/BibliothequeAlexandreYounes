package com.adaming.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adaming.dao.ILivreDao;
import com.adaming.dao.impl.LivreDao;
import com.adaming.model.Livre;

@WebServlet("/serv")
public class MaServlet extends HttpServlet {

	private static final long serialVersionUID = 900208812639970470L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ILivreDao ldao = new LivreDao();

		int id;
		float prix;
		if (req.getParameter("id") == null) {
			id = 0;
		} else {
			id = Integer.parseInt(req.getParameter("id"));
		}
		if (req.getParameter("prix") == null) {
			prix = 0;
		} else {
			prix = Float.parseFloat(req.getParameter("prix"));
		}
		String titre = req.getParameter("titre");
		String auteur = req.getParameter("auteur");

		String operation = req.getParameter("operation");

		if (operation.equals("Afficher")) {
			ArrayList<Livre> listeLivres = ldao.afficherTout();
			ArrayList<Integer> listeid = new ArrayList<>();
			ArrayList<String> listetitres = new ArrayList<>();
			ArrayList<String> listeauteurs = new ArrayList<>();
			ArrayList<Float> listeprix = new ArrayList<>();
			for (int i = 1; i <= listeLivres.size(); i++) {
				listeid.add(listeLivres.get(i).getId());
				listetitres.add(listeLivres.get(i).getTitre());
				listeauteurs.add(listeLivres.get(i).getAuteur());
				listeprix.add(listeLivres.get(i).getPrix());
			}
			if (listeLivres != null) {
//				req.setAttribute("listeLivres", listeLivres);
				req.setAttribute("listeid", listeid);
				req.setAttribute("listetitres", listetitres);
				req.setAttribute("listeauteurs", listeauteurs);
				req.setAttribute("listeprix", listeprix);
				RequestDispatcher dispatcher = req.getRequestDispatcher("affichage.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("operation_ratee.jsp");
				dispatcher.forward(req, resp);
			}
		}

		if (operation.equals("Ajouter")) {
			Livre l = new Livre(titre, auteur, prix);
			if (ldao.ajouterLivre(l)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("ajout.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("operation_ratee.jsp");
				dispatcher.forward(req, resp);
			}
		}

		if (operation.equals("Supprimer")) {
			Livre l = new Livre(id, titre, auteur, prix);
			if (ldao.deleteLivre(l)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("suppression.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("operation_ratee.jsp");
				dispatcher.forward(req, resp);
			}

		}

		if (operation.equals("Modifier")) {
			Livre l = new Livre(id, titre, auteur, prix);
			if (ldao.modifierLivre(l)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("modification.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("operation_ratee.jsp");
				dispatcher.forward(req, resp);
			}

		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
