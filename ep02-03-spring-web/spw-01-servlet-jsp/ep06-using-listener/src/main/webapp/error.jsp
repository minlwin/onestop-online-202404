<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout title="Error">
	
	<app:header icon="bi-exclamation-circle" value="Application Error"></app:header>
	
	<div class="alert alert-info">
		${param.error}
	</div>
	
</app:layout>