<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1,width=device-width"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'/>
<title>Delete</title>
</head>
<body>
<div class="container">
<h2>Delete Method</h2>

<form action="deletemeth">
<div class="col=md-6">
<label>Header:</label>
<input type="text" class="form-control input-sm col-md-7" name="header" id="header"/>
</div>
<div class="col=md-6">
<label>Url:</label>
<input type="text" class="form-control input-sm col-md-7" name="url" id="url"/>
</div>
<div class="col=md-6">
<label>id:</label>
<input type="text" class="form-control input-sm col-md-7" name="id" id="id"/>
</div>
<input class="btn btn-submit"  type="button" value="submit" onclick="geet()">
<div id="msg"></div>
</form>
<div class="col=md-12">
<label>Time:</label>
<input type="text" class="form-control col-md-8" value="${time}"/>
</div>
<div class="col=md-12">
<label>Url:</label>
<textarea class="form-control col-md-8"> ${url}</textarea>
</div>
<hr>
<div class="col=md-12">
<label>Header:</label>
<textarea class="form-control col-md-8" > ${head}</textarea>
</div>
<hr>
<div class="col=md-12">
<label>Body:</label>
<textarea class="form-control col-md-8"> ${bodyy}</textarea>
</div>
<hr>
</div>
<script>
function geet(){
	document.getElementById("msg").innerHTML="Sending request..";
	var u=document.getElementById("url").value;
	var id=document.getElementById("id").value;

	//alert(u);

$.get(
	    "deletemeth",
	    {url : u, id : id},
	    function(data) {
	    	document.getElementById("area").innerHTML= data;
	    }
	);
}	
</script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script> 
<script type="text/javascript"src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>