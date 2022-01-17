
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<%
	HttpServletResponse httpResponse = (HttpServletResponse)response;

	httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	httpResponse.setHeader("Pragma","no-cache"); 
	httpResponse.setDateHeader ("Expires", 0); 
	if ( session.getAttribute("user") == null ) {                               
	                 response.sendRedirect(request.getContextPath() + "/home.jsp");
	                 return;
	 }
	%>
    <div class="container">
        <div class="row">
            <div class="col-sm-2 no-float dashbar">
                <p class="text-center" style="color: rgb(238, 142, 16);font-size:150%; margin-top: 20px;">1849 TEAM</p>
                <button type="button" class="btn btn-light ">
                    <span class="glyphicon glyphicon-th-large"></span> Dashboard
                </button> <br>
                <button type="button" class="btn btn-light " style="margin-top: 10px;height: 5.5%;">
                    <span class="glyphicon glyphicon-user"></span> Staff Manager 
                </button>
            </div>
            <div class="col-sm-10 no-float content">
            	<div class= "welcome position-absolute" style="color:  #000024; margin-top:18px; margin-left:20px">
            		<%
		            String name = (String) session.getAttribute("user");
            		if(name != null){
            			int i=0;
            			char n='x';
            			String name2= "";
            			while (!Character.toString(n).equals("@")){
            				n=name.charAt(i);
            				name2+= n;
            				i++;
            				
            			}
            			name2=name2.substring(0,name2.length()-1);
            			 out.print("Welcome  " + name2 +" !");
            		}
		           
		            %>
            	</div>
                <div class="menu position-absolute">
                    <a href="#"><span class="glyphicon glyphicon-th-large icon" ></span></a>  <a href="#"><span class="glyphicon glyphicon-user icon"></span></a> <a href="${pageContext.request.contextPath}/logout" method="POST" class="icon" style="color: black;">Log out</a>
                </div>
                <img class="img" src="../image/2690606.jpg" alt=""><br>
                <div  style="width: 50%;background: rgb(3, 20, 31);margin-left: -15px;margin-top: -10px;margin-bottom: -10px;">
                    <h4 style="color: beige;padding: 10px;">Members of the team</h4>
                </div>
                <table class="table" style="width: 50%;margin-left: -15px;">
                    <thead class="thead-light" >
                      <tr   >
                        <th  scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Student ID</th>
                        <th scope="col">Class</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr class="tr">
                        <th scope="row">1</th>
                        <td>Member 1</td>
                        <td>Student code 1</td>
                        <td>Class 1</td>
                      </tr>
                      <tr class="tr">
                        <th scope="row">2</th>
                        <td>Member 2</td>
                        <td>Student code 2</td>
                        <td>Class 2</td>
                      </tr>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</body>
</html>