<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>

	<h4>Input Params</h4>
	
	<app:sidebar menu="inputs.jsp">
		<h1>Post Form</h1>
		
		<form action="${root}/inputs" method="post" class="w-50">
			
			<app:form-group label="Day of Week" cssClass="mb-3">
				<select name="day" class="form-select">
					<option value="">Select One</option>
					<c:forEach var="item" items="${days}">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			</app:form-group>
			
			<app:form-group label="Number Input" cssClass="mb-3">
				<input name="value" type="number" class="form-control" placeholder="Enter Value" />
			</app:form-group>
			
			<app:form-group label="Date Input" cssClass="mb-3">
				<input name="date" type="date" class="form-control" />
			</app:form-group>
			
			<button class="btn btn-primary">Send</button>
			
		</form>
		
	</app:sidebar>
	
</app:layout>