<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>
		
	<form id="uploadForm" action="/staff/tasks" 
		enctype="multipart/form-data"
		class="d-flex justify-content-between" method="post">
		
		<h3>Staff Home</h3>
		<sec:csrfInput/>
		
		<input class="d-none" id="fileInput" name="file" type="file">
		
		<button id="uploadBtn" type="button" class="btn btn-primary">Upload Task</button> 
		
	</form>
	
	<!-- Task Grid -->
	<div class="row mt-4 row-cols-3 gx-4 gy-4">
	<c:forEach var="item" items="${tasks}">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5>${item.todo()}</h5>
					<span>${item.owner()}</span>
				</div>
			</div>
		</div>
	</c:forEach>	
	</div>
	
	<script src="/resources/js/tasks.js"></script>
</app:layout>