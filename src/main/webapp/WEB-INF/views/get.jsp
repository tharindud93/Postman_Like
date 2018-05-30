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
<h2>Get Method</h2>

<form action="getmeth">
<div class="col=md-6">
<label>Header:</label>
<input type="text" class="form-control input-sm col-md-7" name="header" id="header"/>
</div>
<div class="col=md-6">
<label>Url:</label>
<input type="text" class="form-control input-sm col-md-7" name="url" id="url"/>
</div>
<div class="col=md-6">
<label>parameter:</label>
<input type="text" class="form-control input-sm col-md-7" name="param" id="param"/>
</div>
<input class="btn btn-submit"  type="button" value="submit" id="btn" onclick="geet()">

</form>
<div class="col=md-4">
<label>Time:</label>
<input type="text" class="form-control col-md-4" value=" ${time}"/>
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
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script> 
<script type="text/javascript"src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
function geet(){

	var u=document.getElementById("url").value;
	var pa=document.getElementById("param").value;
	//alert(u);

$.get(
	    "getmeth",
	    {url : u, param : pa},
	    function(data) {
	    	document.getElementById("area").innerHTML= data;
	    }
	);
}	
</script>
</body>
</html>