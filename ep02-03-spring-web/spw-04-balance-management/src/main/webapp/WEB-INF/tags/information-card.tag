<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="label" required="true" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="icon" required="true" %>
<%@ attribute name="bgColor" required="true" %>

<div class="card ${bgColor}">
	<div class="card-body">
		<h5><i class="${icon}"></i> ${label}</h5>
		<h3 class="mt-4">${value}</h3>
	</div>
</div>
