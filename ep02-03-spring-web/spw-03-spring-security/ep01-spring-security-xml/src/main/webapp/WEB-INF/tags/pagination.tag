<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="pageInfo" type="com.jdc.spring.model.PageInfo" required="true" %>

<div class="d-flex justify-content-between mt-3">
	
	<div class="row">
		<!-- Page Select -->
		<div class="col-auto">
			<select id="pageSelect" class="form-select">
				<option value="10" ${param.size eq 10 ? 'selected' : ''}>10</option>
				<option value="25" ${param.size eq 25 ? 'selected' : ''}>25</option>
				<option value="50" ${param.size eq 50 ? 'selected' : ''}>50</option>
			</select>
		</div>
	
		<!-- Page Links -->
		<div class="col page-links">
			<!-- First -->
			<c:if test="${pageInfo.showFirst()}">
				<button data-page="0" class="btn btn-outline-primary pageLink">
					<i class="bi-arrow-left"></i>
				</button>
			</c:if>
			
			<c:forEach var="item" items="${pageInfo.links()}">
				<button data-page="${item}" class="pageLink btn btn-outline-primary ${item eq pageInfo.page() ? 'active' : ''}">
					${item + 1}
				</button>
			</c:forEach>			
	
			<!-- Last -->
			<c:if test="${pageInfo.showLast()}">
				<button data-page="${pageInfo.totalPage() - 1}" class="btn btn-outline-primary pageLink">
					<i class="bi-arrow-right"></i>
				</button>
			</c:if>
		</div>
	</div>

	
	<!-- Page Informations -->
	<div class="d-flex">
		<!-- Total Page -->
		<div class="input-group me-2">
			<span class="input-group-text">Total Pages</span>
			<span class="form-control">${pageInfo.totalPage()}</span>
		</div>
		
		<!-- Total Records -->
		<div class="input-group">
			<span class="input-group-text">Total Count</span>
			<span class="form-control">${pageInfo.count()}</span>
		</div>
	</div>
	
	<script src="${root}/resources/js/pagination.js"></script>
</div>