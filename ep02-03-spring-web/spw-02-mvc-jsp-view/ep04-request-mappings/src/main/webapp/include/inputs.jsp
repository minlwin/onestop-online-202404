<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<ul class="nav flex-column">
	<li class="nav-item">
		<c:url value="/inputs" var="inputs">
			<c:param name="day" value="TUESDAY" />
			<c:param name="value" value="10" />
			<c:param name="date" value="2025-01-03" />
		</c:url>
		<a href="${inputs}" class="nav-link">Query Params</a>
	</li>
	<li class="nav-item">
		<a href="${root}/inputs/javabean" class="nav-link">Get Form Params</a>
	</li>
	<li class="nav-item">
		<a href="${root}/inputs/record" class="nav-link">Post Form Params</a>
	</li>
	<li class="nav-item">
		<a href="${root}/inputs/path/101" class="nav-link">Path Variable</a>
	</li>
</ul>