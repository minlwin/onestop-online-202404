<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="bi-tag" value="${category.name}"></app:header>
	
	<!-- Category Information -->
	
	<div class="row">
		<!-- Status --> 
		<app:form-group cssClass="col-auto" label="Status">
			<span class="form-control pe-4">
				${category.status}
			</span>
		</app:form-group>
		<!-- Created At -->
		<app:form-group cssClass="col-auto" label="Created At">
			<span class="form-control pe-4">
				${dateTimes.format(category.createdAt)}
			</span>
		</app:form-group>
		<!-- Updated At -->
		<app:form-group cssClass="col-auto" label="Updated At">
			<span class="form-control pe-4">
				${dateTimes.format(category.updatedAt)}
			</span>
		</app:form-group>
		
		<div class="col btn-wrapper">
			<c:url var="edit" value="/categories/edit">
				<c:param name="id" value="${category.id}"></c:param>
			</c:url>
			<a href="${edit}" class="btn btn-outline-primary">
				<i class="bi-pencil"></i> Edit Category
			</a>
			
			<a href="" class="btn btn-outline-danger">
				<i class="bi-plus"></i> Add Product
			</a>
			
			<a href="" class="btn btn-outline-danger">
				<i class="bi-upload"></i> Upload Product
			</a>
		</div>
	
	</div>
	
	<!-- Products in Category -->
	<section class="mt-4">
		<app:sub-header icon="bi-gift" value="Products in Category"></app:sub-header>
		
		<table class="table table-bordered mt-3">
			<thead>
				<tr>
					<th class="text-end">ID</th>
					<th>Name</th>
					<th class="text-end">Price</th>
					<th>Status</th>
					<th class="text-end">Sales</th>
					<th class="text-end">Remains</th>
					<th>Created At</th>
					<th>Updated At</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="item" items="${products}">
				<tr>
					<td class="text-end">1</td>
					<td>Product Name</td>
					<td class="text-end">25,000</td>
					<td>Available</td>
					<td class="text-end">5</td>
					<td class="text-end">20</td>
					<td>2024-10-12 10:00</td>
					<td>2024-10-12 10:00</td>
					<td class="text-center">
						<a href="" class="icon-link">
							<i class="bi-chevron-right"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</section>

</app:layout>