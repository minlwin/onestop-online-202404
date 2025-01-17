<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Products">

	<h3>Product Management</h3>
	
	<a href="${root}/products/edit" class="btn btn-primary">
		Add New Product
	</a>
	
	<table class="table table-striped mt-4">
		<thead>
			<tr>
				<th>Id</th>
				<th>Category</th>
				<th>Name</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${products}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.category.name}</td>
				<td>${item.name}</td>
				<td>${item.price.price} ${item.price.currency}</td>
				<td>
					<c:url value="/products/edit" var="editUrl">
						<c:param name="id" value="${item.id}" />
					</c:url>
					<a href="${editUrl}">Edit</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</app:layout>