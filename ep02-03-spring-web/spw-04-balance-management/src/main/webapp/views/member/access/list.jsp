<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout-member title="ACCESS">
	
	<app:page-title title="Access History"></app:page-title>
	
	<!-- Search Form -->
	<form class="row" id="searchForm">
		
		<input type="hidden" name="page" id="pageInput" />
		<input type="hidden" name="size" id="sizeInput" />

		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">Search All</option>
				<option value="Success" ${param.status eq 'Success' ? 'selected' : ''}>Success</option>
				<option value="Fails" ${param.status eq 'Fails' ? 'selected' : ''}>Fails</option>
			</select>
		</app:form-group>
		
		<app:form-group label="Date From" cssClass="col-auto">
			<input name="dateFrom" type="date" class="form-control" value="${param.dateFrom}" />
		</app:form-group>

		<app:form-group label="Date To" cssClass="col-auto">
			<input name="dateTo" type="date" class="form-control" value="${param.dateTo}" />
		</app:form-group>
		
		<app:form-group label="Keyword" cssClass="col-auto">
			<input name="keyword" class="form-control" placeholder="Search Keyword" value="${param.keyword}" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<table class="table table-striped table-bordered table-hover my-3">
		<thead>
			<tr>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${result.contents()}" var="item">
			<tr>
				<td>${dtf.formatDateTime(item.accessAtLocal)}</td>
				<td>${item.type()}</td>
				<td>${item.status()}</td>
				<td>${item.remark()}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<app:pagination pageResult="${result}" />
</app:layout-member>