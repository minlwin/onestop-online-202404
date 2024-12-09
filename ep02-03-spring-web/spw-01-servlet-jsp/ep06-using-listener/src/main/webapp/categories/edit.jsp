<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<app:header icon="${param.id gt 0 ? 'bi-pencil' : 'bi-plus'}" value="${param.id gt 0 ? 'Edit' : 'Add New'} Category"></app:header>

</app:layout>