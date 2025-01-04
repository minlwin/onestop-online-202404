<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout>

	<h4>Input Params</h4>
	
	<app:sidebar menu="inputs.jsp">
		<h1>Path Variable</h1>
		
		<p>${message}</p>
	</app:sidebar>
		
</app:layout>