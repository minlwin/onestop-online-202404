<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout>

	<h4>Input Params</h4>
	
	<app:sidebar menu="inputs.jsp">
		<h1>Query Params</h1>
		
		<table class="table table-bordered w-50">
			<tr>
				<th>Day</th>
				<td>${day}</td>
			</tr>
			
			<tr>
				<th>Count</th>
				<td>${count}</td>
			</tr>
			
			<tr>
				<th>Date</th>
				<td>${date}</td>
			</tr>

		</table>
	</app:sidebar>
	
</app:layout>