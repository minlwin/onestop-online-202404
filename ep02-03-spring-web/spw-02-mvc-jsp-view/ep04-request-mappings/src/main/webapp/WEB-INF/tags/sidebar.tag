<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="menu" required="true" type="java.lang.String" %>

<div class="row">
	
	<div class="col-3">
		<jsp:include page="/include/${menu}"></jsp:include>
	</div>
	
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
	
</div>