<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout>
	<h3><i class="bi-people"></i> Account Management</h3>
	
	<!-- Search Form -->
	<form class="row">
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
	
	<!-- Pagination -->
	<app:pagination />
	
</app:layout>