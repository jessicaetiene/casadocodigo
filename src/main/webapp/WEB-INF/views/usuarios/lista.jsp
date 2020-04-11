<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuário">
	<jsp:attribute name="extraScripts">
   		<c:url value="/resources/css" var="cssPath" />
		<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
		<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
	</jsp:attribute>
	<jsp:body>

			<div class="container">
				<a href="${s:mvcUrl('UC#form').build() }" class="btn btn-primary  ui-icon-plus">Novo Usuario</a>
				<h1>Lista de Usuários</h1>
				<p> ${sucesso} </p>

				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Nome</th>
						<th>Email</th>
					</tr>
					<c:forEach items="${usuarios }" var="usuario">
						<tr>
							<td>${usuario.nome }</td>
							<td>${usuario.email }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	</jsp:body>
</tags:pageTemplate>