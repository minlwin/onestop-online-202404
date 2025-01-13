<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Products">

	<h3>Product Management</h3>
	
	<a href="${root}/products/edit" class="btn btn-primary">
		Add New Product
	</a>
	
</app:layout>