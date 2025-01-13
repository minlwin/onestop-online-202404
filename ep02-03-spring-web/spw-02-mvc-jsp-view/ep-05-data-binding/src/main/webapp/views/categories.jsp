<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Categories">

	<h3>Category Management</h3>
	
	<button id="uploadBtn" class="btn btn-primary">
		Upload File
	</button>
	
	<div class="row row-cols-4 g-4">
		<c:forEach var="item" items="${list}">
			<div class="col">
				<div class="card">
					<div class="card-body">${item.name}</div>
				</div>
			</div>
		</c:forEach>
	</div>	
	
	<form id="uploadForm" action="${root}/categories" enctype="multipart/form-data" method="post" class="d-none">
		<input id="uploadFile" type="file" name="file" />
	</form>
	
</app:layout>