<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
    
<app:layout>

	<h3><i class="bi-danger"></i> Exception Handling Demo</h3>
	
	<form action="${root}/exception" class="row" method="post">
		<div class="col-auto">
			<app:form-group label="Enter Number">
				<input name="data" value="${param.data}" class="form-control" />
			</app:form-group>
		</div>
		
		<div class="col" style="padding-top:2rem">
			<button class="btn btn-outline-primary" type="submit">
				<i class="bi-send"></i> Send
			</button>
		</div>
	</form>
	
	<p>${intValue}</p>
	
</app:layout>