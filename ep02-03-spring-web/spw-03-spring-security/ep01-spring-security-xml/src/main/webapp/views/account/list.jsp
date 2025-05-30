<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>
	<h3><i class="bi-people"></i> Account Management</h3>
	
	<!-- Search Form -->
	<form class="row mb-3">
		<!-- Status -->
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">All Status</option>
				<option value="false">Active</option>
				<option value="true">Disable</option>
			</select>
		</app:form-group>
		
		<!-- Created From -->
		<app:form-group label="Created From" cssClass="col-auto">
			<input type="date" name="from" class="form-control" />
		</app:form-group>
		
		<!-- Created To -->
		<app:form-group label="Created To" cssClass="col-auto">
			<input type="date" name="to" class="form-control" />
		</app:form-group>
		
		<!-- Keyword -->
		<app:form-group label="Keyword" cssClass="col-auto">
			<input name="keyword" class="form-control" placeholder="Search Keyword" />
		</app:form-group>
		
		<!-- Search Button -->
		<div class="col-auto btn-wrapper">
			<button class="btn btn-outline-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<!-- Search Result -->
	<table class="table table-striped table-bordered table-hover">
	
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Status</th>
				<th>Created At</th>
				<th>Modified At</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="item" items="${result.contents()}">
			<tr>
				<td>${item.name()}</td>
				<td>${item.email()}</td>
				<td>${item.disabled() ? 'Disable' : 'Active'}</td>
				<td>${dateTimes.format(item.createdAt())}</td>
				<td>${dateTimes.format(item.modifiedAt())}</td>
				<td class="text-center">
					<a href="${root}/admin/account/${item.id()}">
						<i class="bi-arrow-right"></i>
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Pagination -->
	<app:pagination pageInfo="${result}" />
	
</app:layout>