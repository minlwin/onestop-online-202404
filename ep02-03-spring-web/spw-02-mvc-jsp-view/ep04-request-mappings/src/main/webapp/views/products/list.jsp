<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>
	
	<div class="d-flex justify-content-between w-100">
		<h3>Product Management</h3>
		
		<a id="uploadBtn" href="#" onclick="return false;" class="btn btn-outline-primary">
			<i class="bi-upload"></i> Upload
		</a>
	</div>
	
	<form id="uploadForm" action="${root}/product/upload" enctype="multipart/form-data" method="post" class="d-none" >
		<input id="uploadFile" type="file" name="file" />
	</form>
	
	<!-- Product List -->
	
	<script src="${root}/resources/js/products.js"></script>
</app:layout>