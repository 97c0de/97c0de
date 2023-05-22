<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:if test="${not empty sessionScope.user and sessionScope.user.id eq 'admin'}">
	<div class="container">
		<h3 id="update_item">
			<a href="main.jsp?page=movie_writeForm"><button id="update_item_button">영화등록</button></a>
		</h3>
	</div>
</c:if>