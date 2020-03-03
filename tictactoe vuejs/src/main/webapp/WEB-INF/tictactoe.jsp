<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>TicTacToe webapp</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="form.css" />
</head>

<body>
	<table style="font-size: 50px">
		<tr>
			<td> <c:if test="${gridArray0 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray0 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray1 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray1 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray2 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray2 eq '2'.charAt(0)}">O</c:if></td>
		</tr>
		<tr>
			<td> <c:if test="${gridArray3 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray3 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray4 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray4 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray5 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray5 eq '2'.charAt(0)}">O</c:if></td>
		</tr>
		<tr>
			<td> <c:if test="${gridArray6 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray6 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray7 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray7 eq '2'.charAt(0)}">O</c:if></td>
			<td> <c:if test="${gridArray8 eq '1'.charAt(0)}">X</c:if> <c:if test="${gridArray8 eq '2'.charAt(0)}">O</c:if></td>
		</tr>
	</table>
	<c:forEach items="${ grids }" var="grid" varStatus="boucle">
		<div class="card" style="width: auto; margin: 2rem; padding: 1rem">
			<h1 style="font-weight: bold">${ grid.grid }</h1>

			<div class="row">
				<div class="column">
					<form action=/TicTacToe/tictactoe >
						<button type="submit" value="${grid.id}" name="PostButton"
							class="btn btn-primary" style="margin: 0.5em">Afficher la Grid</button>
					</form>
				</div>
				<div class="column">
					<form action=/Blog/UpdatePost>
						<button type="submit" value="${grid.id}" name="Modifier"
							class="btn btn-warning" style="margin: 0.5em">Modifier</button>
					</form>
				</div>
				<div class="column">
					<form method="post" action=/Blog/PostsList>
						<button type="submit" value="${grid.id}" name="Supprimer"
							class="btn btn-danger" style="margin: 0.5em">Supprimer</button>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>


</body>
<footer class="page-footer ">
	<div class="mt-5 pt-5 pb-5 page-footer bg-primary">
		<div class="container ">
			<div class="row">
				<div class="col-lg-5 col-xs-12 about-company">
					<h2 style="color: white">A propos</h2>
					<p class="pr-5 text-white">Ce site est un projet d'essai.</p>
				</div>
				<div class="col"></div>
				<div class="col-lg-55 col-xs-12 contact" style="color: white">
					<h4 class="mt-lg-0 mt-sm-4">Contact</h4>
					<i class="fa fa-envelope-o mr-3" style="color: white">victor.pineau@ynov.com</i>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col copyright">
					<p class="">
						<small class="text-white-50">© 2020. All Rights Reserved.</small>
					</p>
				</div>
			</div>
		</div>
	</div>

</footer>
<style>
table {
  border-collapse: collapse;
  text-align: center;
}
td {
 border: 1pt solid black;
  width: 10em;
  height: 10em;
}
tr {

  width: 11em;
  height: 11em;
  background-color: grey;
}
</style>
</html>