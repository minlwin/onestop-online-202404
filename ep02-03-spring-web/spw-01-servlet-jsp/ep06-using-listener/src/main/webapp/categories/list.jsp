<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="bi-tags" value="Category Management"></app:header>
	
	<!-- Search Form -->
	<form class="row">
		<!-- Status -->
		<app:form-group cssClass="col-auto" label="Status">
			<select name="status" class="form-select">
				<option value="">All Status</option>
				<option ${param.status eq 'Available' ? 'selected' : ''} value="Available">Available</option>
				<option ${param.status eq 'Deleted' ? 'selected' : ''} value="Deleted">Deleted</option>
			</select>
		</app:form-group>
		
		<!-- Create From -->
		<app:form-group cssClass="col-auto" label="Create From">
			<input name="createdFrom" value="${param.createdFrom}" type="date" class="form-control" />
		</app:form-group>
		
		<!-- Crate To -->
		<app:form-group cssClass="col-auto" label="Create To">
			<input name="createdTo" value="${param.createdTo}" type="date" class="form-control" />
		</app:form-group>
		
		<!-- Name -->
		<app:form-group cssClass="col-auto" label="Keyword">
			<input name="keyword" value="${param.keyword}" type="text" class="form-control" placeholder="Search Keyword" />
		</app:form-group>
		
		<!-- Search Button -->
		<div class="col btn-wrapper">
			<button type="submit" class="btn btn-outline-primary">
				<i class="bi-search"></i> Search
			</button>
			
			<a href="${root}/categories/edit" class="btn btn-outline-danger">
				<i class="bi-plus"></i> Add New Category
			</a>
		</div>
	</form>
	
	<!-- Result Table -->
	<table class="table table-bordered table-hovered mt-3">
		
		<thead>
			<tr>
				<th class="text-end">ID</th>
				<th>Name</th>
				<th>Status</th>
				<th class="text-end">Products</th>
				<th class="text-end">Sales</th>
				<th>Created At</th>
				<th>Updated At</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="item" items="${list}">
			
			<tr>
				<td class="text-end">${item.id}</td>
				<td>${item.name}</td>
				<td>${item.status}</td>
				<td class="text-end">${item.products}</td>
				<td class="text-end">${item.sales eq null ? 0 : items.sales}</td>
				<td>${dateTimes.format(item.createdAt)}</td>
				<td>${dateTimes.format(item.updatedAt)}</td>
				<td class="text-center">
					<c:url var="details" value="/categories/details">
						<c:param name="id" value="${item.id}"></c:param>
					</c:url>
					<a href="${details}" class="icon-link">
						<i class="bi-chevron-right"></i>
					</a>
				</td>
			</tr>
			
		</c:forEach>
		</tbody>
		
	</table>

</app:layout>