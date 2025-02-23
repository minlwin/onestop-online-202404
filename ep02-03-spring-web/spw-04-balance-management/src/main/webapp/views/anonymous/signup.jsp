<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-anonymous title="Sign Up">

	<main class="loginForm">
		<h3>Sign Up</h3>
		
		<form action="${root}/signup" method="post" class="mt-4">
			
			<app:form-group label="Name" cssClass="mb-3">
				<input type="text" placeholder="Enter Member Name" class="form-control" />
			</app:form-group>

			<app:form-group label="Login ID" cssClass="mb-3">
				<input type="text" placeholder="Enter Login ID" class="form-control" />
			</app:form-group>
			
			<app:form-group label="Password" cssClass="mb-3">
				<input type="password" placeholder="Enter Password" class="form-control" />
			</app:form-group>
			
			<div>
				<a href="${root}/signin" class="btn btn-outline-primary">
					<i class="bi-unlock"></i> Sign In
				</a>
				
				<button class="btn btn-primary">
					<i class="bi-person-plus"></i> Sign Up
				</button>
			</div>
		</form>
	</main>	
</app:layout-anonymous>