<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="${param.id ? 'bi-pencil' : 'bi-plus'}" value="${param.id ? 'Edit Product' : 'Add New Product'}"></app:header>

	<form method="post" class="w-50">
		
		<c:if test="${param.id ne null and param.id gt 0}">
			<input type="hidden" name="id" value="${param.id}" />
		</c:if>
		<input type="hidden" name="categoryId" value="${param.categoryId}" />
		
		<div class="row mb-3">
			<app:form-group cssClass="col" label="Category">
				<span class="form-control">${category.name}</span>
			</app:form-group>

			<app:form-group cssClass="col" label="Product Name">
				<input name="name" type="text" class="form-control" placeholder="Enter Product Name" required="required" />
			</app:form-group>
		</div>
		
		<div class="row mb-3">
		
			<!-- Status -->
			<app:form-group cssClass="col" label="Status">
				<select name="status" required="required" class="form-select">
					<option value="">Select One</option>
					<option ${(param.status ne null ? params.status : (product.status ne null ? product.status : '')) eq 'Available' ? 'selected' : ''} value="Available">Available</option>
					<option ${(param.status ne null ? params.status : (product.status ne null ? product.status : '')) eq 'Deleted' ? 'selected' : ''} value="Deleted">Deleted</option>
				</select>
			</app:form-group>

			<app:form-group cssClass="col" label="Product Price">
				<input name="price" type="number" class="form-control" required="required" />
			</app:form-group>
		</div>


		
		<button type="submit" class="btn btn-outline-danger">
			<i class="bi-save"></i> Save Product
		</button>

	</form>
</app:layout>