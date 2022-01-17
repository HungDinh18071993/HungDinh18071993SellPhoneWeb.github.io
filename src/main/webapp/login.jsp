<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
 <%
     Cookie[] listCookie = request.getCookies();
     String user = "";
     String pass = "";
     int co = 0;
     if(listCookie != null){
        while(co < listCookie.length){
          if(listCookie[co].getName().equals("user")){
            user = listCookie[co].getValue();
           }
          if(listCookie[co].getName().equals("pass")){
            pass = listCookie[co].getValue();
           }
          co++;
        }
  
      }
   %>
<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
							<div class="text w-100">
								<h2>Welcome back</h2>
								<p>To keep connected with us please login with personal info</p>
							</div>
			      </div>
						<div class="login-wrap p-4 p-lg-5">
			      	<div class="text-center d-flex align-items-center">
			      		<div class="w-100">
			      			<h3 class="mb-4">Log In</h3>
			      		</div>

			      	</div>
							<form class="signin-form" action="login" method="POST" >
			      		<div class="form-group mb-3">
			      			<label class="label" for="name">Username</label>
			      			<input type="text" class="form-control" name="username"  value="<%out.print(user);%>" placeholder="Username" required>
			      		</div>
		            <div class="form-group mb-3">
		            	<label class="label" for="password">Password</label>
		              <input type="password" class="form-control" name="password"  value="<%out.print(pass);%>" placeholder="Password" required>
		            </div>
		            <div class="form-group " >
		            	<button type="submit" class="form-control btn  btn-primary submit px-10">Log In</button>
		            </div>
		            <div class="form-group d-md-flex">
		            	<div class="w-50 text-left">
			            	<label class="checkbox-wrap checkbox-primary mb-0">Remember Me
									  <input type="checkbox" name="chkRemember" value="OFF" >
									  <span class="checkmark"></span>
										</label>
									</div>
									<div class="w-50 text-md-right">
										<a href="#">Forgot Password</a>
									</div>
		            </div>
		            <%
		            HttpSession session2 = request.getSession();
		            String er = (String) session2.getAttribute("error");
		        	if (er!=null){
		        		 out.print(er);
		        	}
		  
		            %>
		          </form>
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>