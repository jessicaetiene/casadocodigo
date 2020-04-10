<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Pedidos">

<jsp:body>
    <section class="container middle">
        <h2 id="cart-title">Lista de Pedidos Atuais</h2>
        <table id="cart-table">
            <thead>
            <tr>
                <th width="10%">ID</th>
                <th width="10%">Valor</th>
                <th width="10%">Data Pedido</th>
                <th width="65%">Títulos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pedido.itens }" var="item">
                <tr>
                    <td>${item.id }</td>
                    <td>${item.valor }</td>
                    <td>${pedido.dataFormatada(item.data) }</td>
                    <td>${pedido.titulos(item.produtos) }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</jsp:body>
</tags:pageTemplate>