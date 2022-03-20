<%-- 
    Document   : login
    Created on : Mar 16, 2022, 9:44:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%;
            }
            .contain{
                background-color: whitesmoke;
                height: 300px;
                width: 300px;
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -50%); 
                border-radius: 25px;
                box-shadow: 10px 10px 10px gray;
            }
            .title{
                font-family: Poppins-Bold;
                font-size: 40px;
                color: #333;
                line-height: 1.2;
                text-align: center;
                width: 100%;
                display: block;  
                padding-top: 10px;
            }
            .userInput{
                font-family: Poppins-Medium;
                font-size: 20px;
                line-height: 2;
                color: #666;
                display: block;
                width: 65%;
                background: #e6e6e6;
                height: 30px;
                border-radius: 25px;
                padding: 0 50px 0 50px;
            }
            .loginBtn{
                font-family: Montserrat-Bold;
                font-size: 15px;
                line-height: 1.5;
                color: #fff;
                text-transform: uppercase;
                width: 100%;
                height: 35px;
                border-radius: 25px;
                background: #57b846;
                justify-content: center;
                align-items: center;
                padding: 0 25px;
            }
            .contain h3{
                font-family: Montserrat-Bold;
                font-size: 11px;
                color: red;
                text-align: center;
            }
            footer{
                position: absolute;
                bottom: 0;
                left: 0;
                right: 0;
                background: grey;
                height: auto;
                width: 100vw;
                padding-top: 0px;
                color: #fff;
            }
        </style>
        <%
            String whoLogin = (String) request.getSession().getAttribute("whoLogin");
            String loginfail = (String) request.getAttribute("loginFail");
            if(loginfail == null) loginfail = "";
        %>
    </head>
    <body>
        <div class="contain">
            <form action="login" method="POST">
                <span class="title"><%=whoLogin%> Login</span> </br>
                Username: </br> <input class="userInput" type="text" name="username" placeholder="Enter Username" /> <br/>
                Password: </br> <input class="userInput" type="password" name="password" placeholder="Enter Password"/> <br/>
                <input class="loginBtn" type="submit" value="Login" />
            </form>
            <h3><%=loginfail%></h3>
        </div>
        <footer>
            
        </footer>
    </body>
</html>
