<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Customers">

	<!-- Add New Button -->
	<a href="${pageContext.request.contextPath}/customer/edit" class="btn btn-primary">Add Customer</a>
	
	<!-- List -->
	<section class="mt-3">
		<c:choose>
			<c:when test="${not empty customers}">
			
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Date of Birth</th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="item" items="${customers}">
						<tr>
							<td>${item.id()}</td>
							<td>${item.name()}</td>
							<td>${item.phone()}</td>
							<td>${item.email()}</td>
							<td>${item.gender()}</td>
							<td>${item.dob()}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info">
					There is no customer. Please create customers.
				</div>
			</c:otherwise>
		
		</c:choose>
	</section>
	
</app:layout>
