<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<app:layout>
	<h3><i class="bi-unlock"></i> Sign Up</h3>
	
	<sf:form method="post" modelAttribute="form" class="w-25">
	
		<div class="mb-3">
			<label class="form-label">Name</label>
			<sf:input path="name" cssClass="form-control" placeholder="Enter Customer Name" />
			<sf:errors path="name" cssClass="text-secondary" />
		</div>

		<div class="mb-3">
			<label class="form-label">Email</label>
			<sf:input path="email" type="email" cssClass="form-control" placeholder="Enter Email" />
			<sf:errors path="email" cssClass="text-secondary" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Password</label>
			<sf:input path="password" type="password" cssClass="form-control" placeholder="Enter Password" />
			<sf:errors path="password" cssClass="text-secondary" />
		</div>
		
		<div>
			<a href="${root}/authenticate" class="btn btn-outline-primary">
				Sign In
			</a>		
			<button class="btn btn-primary">
				Sign Up
			</button>
		</div>
	</sf:form>
</app:layout>