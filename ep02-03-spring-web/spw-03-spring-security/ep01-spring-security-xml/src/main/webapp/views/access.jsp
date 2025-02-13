<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>
	<h3><i class="bi-ui-checks"></i> Access History</h3>
	
	<form id="searchForm" class="row mt-3">
	
		<input type="hidden" name="page" id="pageInput" value="${param.page}">
		<input type="hidden" name="size" id="sizeInput" value="${param.size}">

		<app:form-group cssClass="col-auto" label="Action">
			<select name="action" class="form-select">
				<option value="">All Actions</option>
				<c:forEach var="item" items="${types}">
					<option value="${item}" ${item eq param.action ? 'selected' : ''}>${item.displayName()}</option>
				</c:forEach>
			</select>
		</app:form-group>

		<app:form-group cssClass="col-auto" label="Status">
			<select name="status" class="form-select">
				<option value="">All Statuses</option>
				<c:forEach var="item" items="${statuses}">
					<option value="${item}" ${item eq param.status ? 'selected' : ''}>${item}</option>
				</c:forEach>
			</select>
		</app:form-group>

		<app:form-group cssClass="col-auto" label="Date From">
			<input type="date" name="from" class="form-control" value="${param.from}" />
		</app:form-group>

		<app:form-group cssClass="col-auto" label="Date To">
			<input type="date" name="to" class="form-control" value="${param.to}" />
		</app:form-group>
		
		<app:form-group cssClass="col-auto" label="Keyword">
			<input name="keyword" class="form-control" placeholder="Search Keyword" value="${param.keyword}" />
		</app:form-group>
		
		<div class="btn-wrapper col">
			<button type="button" id="searchBtn" class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<!-- Result Table -->
	<table class="table table-bordered table-striped table-hover mt-3">
		<thead>
			<tr>
				<th>Login ID</th>
				<th>Action</th>
				<th>Status</th>
				<th>Access At</th>
				<th>Message</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="item" items="${result.contents()}">
			<tr>
				<td>${item.username()}</td>
				<td>${item.action().displayName()}</td>
				<td>${item.status()}</td>
				<td>${dateTimes.format(item.accessAt)}</td>
				<td>${item.remark()}</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<!-- Pagination -->
	<app:pagination pageInfo="${result}" />
</app:layout>