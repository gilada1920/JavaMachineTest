
<html>
<head>
<style>
p{
color: #fff;
font-size: 20px;
}
    span
   {
     font-size: 22px;
     color: white;
     margin-left: 650px;
     font-style: bold;
   }
   
   body {
   background: rgb(2,0,36);
    background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 35%, rgba(0,212,255,1) 100%);
    font-family: 'Roboto', sans-serif;
}

.login-box {
    margin-top: 45px;
    height: auto;
    background: #1A2226;
    margin-left:170px;
    margin-right:170px;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}

.login-key {
    height: 50px;
    font-size: 80px;
    line-height: 100px;
    background: -webkit-linear-gradient(#27EF9F, #0DB8DE);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

.login-title {
    margin-top: 15px;
    text-align: center;
    font-size: 40px;
    letter-spacing: 2px;
    margin-top: 15px;
    font-weight: bold;
    color: #ECF0F5;
}

.login-form {
    margin-top: 25px;
    text-align: center;
}

input[type=text] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    font-size:20px;
    outline: 0;
    margin-bottom: 20px;
    padding-left: 0px;
    color: #ECF0F5;
}

input[type=text] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    font-size:20px;
    outline: 0;
    padding-left: 0px;
    margin-bottom: 20px;
    color: #ECF0F5;
}

.form-group {
padding:5px;
    margin-bottom: 20px;
    outline: 0px;
}

.form-control:focus {
    border-color: inherit;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-bottom: 2px solid #0DB8DE;
    outline: 0;
    background-color: #1A2226;
    color: #ECF0F5;
}

input:focus {
    outline: none;
    box-shadow: 0 0 0;
}

label {
    margin-bottom: 0px;
}

.form-control-label {
    font-size: 15px;
    color: #6C6C6C;
    font-weight: bold;
    letter-spacing: 1px;
}

.btn-outline-primary {
    border-color: #0DB8DE;
    color: #0DB8DE;
    border-radius: 0px;
    padding:10px;
    font-weight: bold;
    letter-spacing: 1px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.btn-outline-primary:hover {
    background-color: #0DB8DE;
    right: 0px;
}

.login-btm {
    text-align: center;
}

.login-button {
    padding-right: 0px;
    text-align: center;
    margin-bottom: 100px;
    margin:10px;
    padding:10px;
    padding-bottom: 100px;
}

.login-text {
    text-align: left;
    padding-left: 0px;
    color: #A2A4A4;
}

.loginbttm {
    padding: 0px;
}



   
</style>
<script>

var xmlhttp;
var buttonClicked;
var message;

		function sendData(button)
		{
			var cid = document.categoryform.cid.value;
			var cname = document.categoryform.cname.value;
		  
			var javascriptobject={"cid":cid,"cname":cname}
			xmlhttp = new XMLHttpRequest();
			
			 buttonClicked = button.value;
			if(buttonClicked=="post")
			{	
				 message = "Data Is Save Successfully";
				xmlhttp.open("post","categoryapi/insertCategory");
			}
			else
			{
				 message = "Data Is Update Successfully";
				xmlhttp.open("put","categoryapi/updateCategory");
			}
			xmlhttp.onload=displayResponse;
			
			var jsonstring = JSON.stringify(javascriptobject);
			
			xmlhttp.setRequestHeader('Content-type','application/json')
			
			xmlhttp.send(jsonstring);
			
			alert("Data Is sent to API");
		}


		function displayResponse()
		{
			document.getElementById("message").innerHTML= message;

			alert(xmlhttp.responseText);
		}

		function getData(button)
		{
			var cid = document.categoryform.cid.value;
		  
			xmlhttp = new XMLHttpRequest();
			
			 buttonClicked = button.value;
			
			if(buttonClicked =="get")
			{
				 message = "Data Is retrieved Successfully";
			     xmlhttp.open("get","categoryapi/getCategory/"+cid);
			}
			else
			{
				 message = "Data Is Delete Successfully";
			     xmlhttp.open("delete","categoryapi/deleteCategory/"+cid);
			}
		
			
			xmlhttp.onload=displayResponse2;
			
			xmlhttp.send();
			
		}

function displayResponse2()
{
	var jsonstring = xmlhttp.responseText;
	var obj=JSON.parse(jsonstring);
	
	var cname=obj.cname;
	if(obj.message!=undefined)
	{
		document.categoryform.cname.value = "";
		document.getElementById("message").innerHTML= obj.message;
	
	}else
	{
		document.categoryform.cname.value = cname;
		document.getElementById("message").innerHTML= message;

	}

}
function getAllData()
{
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onload=displayResponse3;
    xmlhttp.open("get","categoryapi/getAllCategory");
    xmlhttp.send();
}

function displayResponse3()
{
	alert(xmlhttp.responseText);
	
	var allJSONStrings = xmlhttp.responseText;
	
	var p1 = document.getElementById("p1");
	
	var data="";
			
	p1.innerHTML = allJSONStrings;
}
</script>

</head>

<body>
<br>
<span id ="message">Waiting</span>
  
   <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    CRUD
                </div>

                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form action="" name=categoryform >
                            <div class="form-group">
                                <label class="form-control-label">Enter Category ID</label>
                               
                <br>
                                <input type="text" name=cid  class="form-control" class="form-control">
                            </div>
                    
                            <div class="form-group">
                                <label class="form-control-label" class="form-control">Data</label>
                                
                               <br>
                                <input type="text" name=cname class="form-control"class="form-control" >
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                                    <!-- Error Message -->
                                </div>
                                <div class="login-btm login-button">
                                    
                                    <button type="button" value=post onclick="sendData(this)" class="btn btn-outline-primary">Insert Data</button>
									<button type="button" value=get onclick="getData(this)" class="btn btn-outline-primary">Get Data</button>
									<button type="button" value=put onclick="sendData(this)" class="btn btn-outline-primary">Update Data</button>
									<button type="button" value=delete onclick="getData(this)" class="btn btn-outline-primary">Delete Data</button>
									<button type="button" value=getAll onclick="getAllData()" class="btn btn-outline-primary">Get All Data</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
  <br>
  <br>
    <p id="p1">All Data</p>
</body>
</html>