<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" required="true" %>
<%@ attribute name="cssClass" %>

<div class="${cssClass}">
	<label class="form-label">${label}</label>
	<jsp:doBody />
</div>
