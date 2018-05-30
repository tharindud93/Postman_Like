<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1,width=device-width"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'/>
<title>Home</title>
</head>
<body>
<div class="container">
<div class="col-md=12"><hr></div>
<div class="form-group col-md-4">
<select class="form-control" name="method" id="method" onchange="methodview(this);">
<option value="get">GET</option>
<option value="post">POST</option>
<option value="put">PUT</option>
<option value="delete">DELETE</option>
</select>
</div>
<div class="col-md=12"></div>
<div id="area" class="warning">
<%@include file="get.jsp" %>
</div>
</div>
<script>
function methodview(opt){
	//var select=document.getElementById.InnerHTML("method");

	switch(opt.value){
	case "get":
		$("#area").load("get");
		break;
	case "post":
		//$("#area").set("");
		$("#area").load("post");
		break;
	case "put":
		$("#area").load("put");
		break;
	case "delete":
		$("#area").load("delete");
		break;
	}
}
</script>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script> 
<script type="text/javascript"src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>