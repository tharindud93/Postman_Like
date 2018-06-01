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
<h2>Post Method</h2>

<form action="postmeth">
<div class="col=md-6">
<label>Header:</label>
<input type="text" class="form-control input-sm col-md-7" name="headerval" id="headerval"/>
</div>
<div class="col=md-6">
<label>Url:</label>
<input type="text" class="form-control input-sm col-md-7" name="url" id="url"/>
</div>
<div class="col=md-6">
<label>name:</label>
<input type="text" class="form-control input-sm col-md-7" name="name" id="name"/>
</div>
<div class="col=md-6">
<label>Surname:</label>
<input type="text" class="form-control input-sm col-md-7" name="surname" id="surname"/>
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
	var name=document.getElementById("name").value;
	var surname=document.getElementById("surname").value;
	//alert(u);

$.get(
	    "postmeth",
	    {url : u, name : name,surname:surname},
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