<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="row">
	
	<div class="col-3">
		<ul class="nav flex-column">
			<li class="nav-item">
				<a href="${root}/returns/handler1" class="nav-link">String Type</a>
			</li>
			<li class="nav-item">
				<a href="${root}/returns/handler2" class="nav-link">Model And View</a>
			</li>
			<li class="nav-item">
				<a href="${root}/returns/handler3" class="nav-link">Void Return</a>
			</li>
			<li class="nav-item">
				<a href="${root}/returns/handler4" class="nav-link">Redirection</a>
			</li>
		</ul>
	</div>
	
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
	
</div>