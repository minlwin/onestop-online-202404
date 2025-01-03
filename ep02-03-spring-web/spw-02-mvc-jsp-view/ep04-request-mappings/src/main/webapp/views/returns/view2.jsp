<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>

	<h4>Return Type for Handler Methods</h4>
	
	<app:returns>
		<!-- Some Other Contents -->
		<h1>Returning Model And View</h1>
		
		<p>${message}</p>
		
		<ul>
		<c:forEach var="day" items="${days}">
			<li>${day}</li>
		</c:forEach>
		</ul>
	</app:returns>
	
</app:layout>