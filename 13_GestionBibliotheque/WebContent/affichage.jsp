<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Modification livre réussie</title>
</head>

<body>
	<br>
	<div align="center">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Titre</th>
					<th scope="col">Auteur</th>
					<th scope="col">Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="id" items="${listeid}">
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${id}" /></td>
					</tr>
				</c:forEach>
				<c:forEach var="titre" items="${listetitres}">
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${titre}" /></td>
					</tr>
				</c:forEach>
				<c:forEach var="auteurs" items="${listeauteurs}">
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${auteurs}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 			<table border="1" cellpadding="5"> -->
		<%-- 				<caption> --%>
		<!-- 					<h2>Liste des livres :</h2> -->
		<%-- 				</caption> --%>
		<!-- 				<tr> -->
		<!-- 					<th>Bibliothèque</th> -->
		<!-- 				</tr> -->
		<%-- 				<c:forEach var="element" items="${listeLivres}"> --%>
		<!-- 					<tr> -->
		<%-- 						<td><c:out value="${element}" /></td> --%>
		<!-- 					</tr> -->
		<%-- 				</c:forEach> --%>
		<!-- 			</table> -->
	</div>

	<br>
	<a href="http://localhost:8080/13_GestionBibliotheque"><button>Retour
			au menu principal</button></a>
</body>
</html>