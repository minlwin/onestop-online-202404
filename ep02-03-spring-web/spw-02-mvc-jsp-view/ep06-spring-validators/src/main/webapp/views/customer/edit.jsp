<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<app:layout title="Customer Edit">
	
	<sf:form action="${pageContext.request.contextPath}/customer/edit" 
		method="post" modelAttribute="form" cssClass="w-50">
		
		<div class="mb-3">
			<label class="text-sm text-secondary">Name</label>
			<sf:input path="name" placeholder="Enter Customer Name" type="text" class="form-control" />
			<sf:errors path="name" cssClass="text-sm text-danger" />
		</div>
	
		<div class="mb-3">
			<label class="text-sm text-secondary">Phone</label>
			<sf:input path="phone" placeholder="Enter Phone Number" type="tel" class="form-control" />
			<sf:errors path="phone" cssClass="text-sm text-danger" />
		</div>

		<div class="mb-3">
			<label class="text-sm text-secondary">Email</label>
			<sf:input path="email" placeholder="Enter Email Address" type="email" class="form-control" />
			<sf:errors path="email" cssClass="text-sm text-danger" />
		</div>

		<div class="mb-3">
			<label class="text-sm text-secondary">Date of Birth</label>
			<sf:input path="dob" type="date" class="form-control" />
			<sf:errors path="dob" cssClass="text-sm text-danger" />
		</div>

		<div class="mb-3">
			<label class="text-sm text-secondary">Gender</label>
			<sf:select path="gender" cssClass="form-select">
				<option value="">Select Gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
			</sf:select>
			<sf:errors path="gender" cssClass="text-sm text-danger" />
		</div>
		
		<div>
			<button type="submit" class="btn btn-primary">Save Customer</button>
		</div>
	</sf:form>
	
</app:layout>
