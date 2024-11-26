<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Java Web</title>
</head>
<body>

	<h1>Hello Servlet with XML</h1>
	
	<ul>
		<li>
			<a href="hello?name=Thidar&phone=0911123334">Hello Servlet</a>
		</li>
		<li>
			<a href="header">Header Info Servlet</a>
		</li>
	</ul>
	
	<form method="post" action="hello">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" placeholder="Enter Name" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="tel" name="phone" placeholder="Enter Phone" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Send</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>