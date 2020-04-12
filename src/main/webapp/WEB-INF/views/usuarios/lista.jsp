<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Cadastro de Usuário">
	<jsp:body>
			<div class="container">
				<a href="${s:mvcUrl('UC#form').build() }">Novo Usuario</a>
				<h1>Lista de Usuários</h1>
				<p> ${sucesso} </p>

				<table>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Roles</th>
						<th></th>
					</tr>
					<c:forEach items="${usuarios }" var="usuario">
						<tr>
							<td>${usuario.nome }</td>
							<td>${usuario.email }</td>
							<td>
								<c:if test="${not empty usuario.roles }">
									${usuario.roles }
								</c:if>
							</td>
							<td><a href="${s:mvcUrl('UC#formRole').arg(0, usuario.email).build() }">+</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
	</jsp:body>
</tags:pageTemplate>