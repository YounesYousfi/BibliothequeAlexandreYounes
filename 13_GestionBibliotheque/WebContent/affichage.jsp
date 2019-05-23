<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Affichage Liste</title>
</head>

<body style="margin-left:200px;margin-right:200px">
	<br>
	<div align="center">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Titre</th>
					<th scope="col">Auteur</th>
					<th scope="col">Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="livre" items="${listeLivres}">
				<tr>
					<td><c:out value="${livre.id}" /></td>
					<td><c:out value="${livre.titre}" /></td>
					<td><c:out value="${livre.auteur}" /></td>
					<td><c:out value="${livre.prix}" /></td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>

		<br><br>
		
		<a href="http://localhost:8080/13_GestionBibliotheque"><button type="button" class="btn btn-dark">Retour au menu principal</button></a>
	</div>


</body>
</html>