<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="phone" %>
<%@ attribute name="email" %>
<%@ attribute name="address" %>

<div class="card text-bg-light h-100">
	<div class="card-body">
		<h5><i class="bi-telephone"></i> Contact Info</h5>
		
		<div class="mb-3">
			<span class="text-secondary">Phone</span>
			<div>${phone ne null and phone ne '' ? phone : 'Un Defined'}</div>
		</div>
		
		<div class="mb-3">
			<span class="text-secondary">Email</span>
			<div>${email ne null and email ne '' ? email : 'Un Defined'}</div>
		</div>

		<div class="mb-3">
			<span class="text-secondary">Address</span>
			<div>${address ne null and address ne '' ? address : 'Un Defined'}</div>
		</div>
	</div>
</div>