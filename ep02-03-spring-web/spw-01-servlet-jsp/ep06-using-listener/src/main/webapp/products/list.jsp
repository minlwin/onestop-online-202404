<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="bi-gift" value="Product Management"></app:header>
	
	<!-- Search Form -->
	<form class="row mb-3">
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
			<input type="date" value="${param.createFrom}" name="createFrom" class="form-control" />
		</app:form-group>
		
		<!-- Create To -->
		<app:form-group cssClass="col-auto" label="Create To">
			<input type="date" value="${param.createTo}" name="createTo" class="form-control" />
		</app:form-group>
		
		<!-- Keyword -->
		<app:form-group cssClass="col-auto" label="Keyword">
			<input name="keyword" value="${param.keyword}" placeholder="Search Keyword" class="form-control" />
		</app:form-group>
		
		<!-- Search Button -->
		<div class="col btn-wrapper">
			<button type="submit" class="btn btn-outline-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<!-- Product List -->
	<c:choose>
		<c:when test="${not empty list}">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Category</th>
						<th>Name</th>
						<th>Status</th>
						<th>Created At</th>
						<th>Updated At</th>
						<th class="text-end">Price</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.categoryName}</td>
						<td>${item.name}</td>
						<td>${item.deleted ? 'Deleted' : 'Available'}</td>
						<td>${dateTimes.format(item.createdAt)}</td>
						<td>${dateTimes.format(item.updatedAt)}</td>
						<td class="text-end">${item.price}</td>
						<td class="text-center">
							<c:url value="/products/details" var="details">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<a href="${details}" class="icon-link">
								<i class="bi-chevron-right"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:when>
		
		<c:otherwise>
			<div class="alert alert-info">
				<i class="bi-info-circle"></i> There is no products. 
			</div>
		</c:otherwise>
	</c:choose>

</app:layout>