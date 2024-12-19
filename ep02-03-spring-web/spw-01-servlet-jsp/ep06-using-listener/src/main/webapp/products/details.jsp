<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Product">
	
	<script src="${root}/static/js/photo-upload.js"></script>
	
	<app:header icon="bi-gift" value="${product.name}"></app:header>
	
	<div class="row">
		<!-- Photos -->
		<div class="col-4">
			
			<div class="mb-4">
			<c:choose>
				
				<c:when test="${empty images}">
					<img class="img-fluid w-100" src="${pageContext.request.contextPath}/static/images/default-image.jpg" alt="Default Image" />	
				</c:when>
				
				<c:otherwise>
					
				
				</c:otherwise>
			
			</c:choose>
			</div>
			
			<button id="uploadBtn" class="btn btn-outline-primary">
				<i class="bi-camera"></i> Upload Photos
			</button>
		
		</div>
		
		<!-- Product Info -->
		<div class="col">
		
		</div>
	</div>
	
	
	<form id="uploadForm" action="${root}/products/photos" method="post" 
		enctype="multipart/form-data" class="d-none">
		<input type="hidden" name="productId" value="${product.id}" />
		<input id="uploadFiles" type="file" multiple="multiple" >
	</form>

</app:layout>