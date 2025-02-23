<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" %>
<%@ attribute name="cssClass" %>

<div class="${cssClass}">
	<label class="form-label">${label}</label>
	<jsp:doBody></jsp:doBody>
</div>