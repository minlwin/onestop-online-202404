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
				<option value="Available">Available</option>
				<option value="Deleted">Deleted</option>
			</select>
		</app:form-group>
		
		<!-- Create From -->
		<app:form-group cssClass="col-auto" label="Create From">
			<input type="date" class="form-control" />
		</app:form-group>
		
		<!-- Crate To -->
		<app:form-group cssClass="col-auto" label="Create To">
			<input type="date" class="form-control" />
		</app:form-group>
		
		<!-- Name -->
		<app:form-group cssClass="col-auto" label="Keyword">
			<input type="text" class="form-control" placeholder="Search Keyword" />
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
				<td class="text-end">1</td>
				<td>Category Name</td>
				<td>Available</td>
				<td class="text-end">5</td>
				<td class="text-end">20</td>
				<td>2024-10-11 09:00</td>
				<td>2024-12-09 09:00</td>
				<td class="text-center">
					<a href="${root}/categories/details" class="icon-link">
						<i class="bi-chevron-right"></i>
					</a>
				</td>
			</tr>
			
		</c:forEach>
		</tbody>
		
	</table>

</app:layout>