<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout title="Category">
	
	<app:header icon="bi-cart-check" value="Sale History"></app:header>
	
	<!-- Search Form -->
	<form action="${root}/sales" class="row">
		
		<app:form-group cssClass="col-auto" label="Date From">
			<input name="dateFrom" type="date" class="form-control" />
		</app:form-group>

		<app:form-group cssClass="col-auto" label="Date From">
			<input name="dateFrom" type="date" class="form-control" />
		</app:form-group>
		
		<app:form-group cssClass="col-auto" label="Customer">
			<input name="customer" type="text" placeholder="Search Customer" class="form-control" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-outline-primary ">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<!-- Table View -->
	<table class="mt-3 table table-bordered table-hover">
		<thead>
			<tr>
				<th>Sale ID</th>
				<th>Customer</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Sale At</th>
				<th class="text-end">Items</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="item" items="${list}">
		
		<tr>
			<td>${item.id}</td>
			<td>${item.customer}</td>
			<td>${item.phone}</td>
			<td>${item.email}</td>
			<td>${dateTimes.format(item.saleAt)}</td>
			<td class="text-end">${item.items}</td>
			<td class="text-end">
				<fmt:formatNumber value="${item.saleTotal}" />
			</td>
		</tr>
		
		</c:forEach>	
		</tbody>
	</table>

</app:layout>