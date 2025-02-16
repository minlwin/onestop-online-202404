<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<app:layout>
		
	<h3>Public Home</h3>
	
	<sec:authentication property="name" var="userName"/>	
	
	<span>${userName}</span>
	
</app:layout>