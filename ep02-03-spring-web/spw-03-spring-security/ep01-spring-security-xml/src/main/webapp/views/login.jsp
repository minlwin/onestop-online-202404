<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<app:layout>
	<h3><i class="bi-unlock"></i> Login</h3>
	
	<form method="post" class="w-25">
	
		<c:if test="${param.error ne null}">
			<div class="alert alert-info">${param.error}</div>
		</c:if>
		
		<sec:csrfInput/>
		
		<div class="mb-3">
			<label class="form-label">Login ID</label>
			<input name="username" type="text" class="form-control" placeholder="Enter Login ID" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Password</label>
			<input name="password" type="password" class="form-control" placeholder="Enter Password" />
		</div>
		
		<button class="btn btn-outline-primary">
			Login
		</button>
	</form>
</app:layout>