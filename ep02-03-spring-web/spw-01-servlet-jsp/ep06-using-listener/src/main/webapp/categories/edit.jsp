<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="${param.id gt 0 ? 'bi-pencil' : 'bi-plus'}" value="${param.id gt 0 ? 'Edit' : 'Add New'} Category"></app:header>

	
	<form action="${root}/categories" class="w-25" method="post">
	
		<input type="hidden" name="id" value="${param.id}" />
		
		<!-- Status -->
		<app:form-group cssClass="mb-3" label="Status">
			<select name="status" required="required" class="form-select">
				<option value="">Select One</option>
				<option ${(param.status ne null ? params.status : (category.status ne null ? category.status : '')) eq 'Available' ? 'selected' : ''} value="Available">Available</option>
				<option ${(param.status ne null ? params.status : (category.status ne null ? category.status : '')) eq 'Deleted' ? 'selected' : ''} value="Deleted">Deleted</option>
			</select>
		</app:form-group>
		
		<!-- Name -->
		<app:form-group cssClass="mb-3" label="Name">
			<input name="name" required="required" value="${param.name ne null ? param.name : (category.name ne null ? category.name : '')}" type="text" class="form-control" placeholder="Enter Name" />
		</app:form-group>
		
		<button type="submit" class="btn btn-outline-primary">
			<i class="bi-save"></i> Save Category
		</button>
	</form>

</app:layout>