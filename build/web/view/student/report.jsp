<%-- 
    Document   : report
    Created on : Mar 17, 2022, 3:15:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Page</title>
        <style>           
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%;
            }
            .container{
                background-color: whitesmoke;
                width: 500px;
                height: 650px;
                margin: auto;
                border-radius: 10px;
                box-shadow: 10px 10px 10px gray;
            }
            .title{
                margin: 10px auto 10px auto;
                width: 80%;
                height: 70px;
            }
            .content{
                margin: 10px auto 10px auto;
                width: 80%;
                height: 500px;
            }
            .inpsm{
                margin: 10px auto 10px auto;
                width: 100%;
                height: 50px;
            }
            .inp{
                margin: 10px auto 10px auto;
                width: 400px;
                height: 30px;
            }
            .t{
                width: 50px;
                height: 20px;
                margin: auto;
            }
            .ta{
                margin: 10px auto 10px auto;
                width: 400px;
                height: 450px; 
            }
            #sm{
                margin: 10px auto 10px auto;
                width: 100%;
                height: 40px;
            }
            .an{
                text-align: center;
                color: red;
            }
        </style>
        <%
            String done = (String) request.getAttribute("done");
            if (done == null) {
                done = "";
            }
        %>
    </head>
    <body>
        <div class="container">
            <form action="stuReport" method="POST">
                <div class="title">
                    <label class="t">Title:</label> </br>
                    <input class="inp" type="text" name="title"/> <br/>
                </div>
                <div class="content">
                    <label class="t">Content: </label></br>
                    <textarea class="ta" type="text" name="content"> </textarea> <br/>
                </div>
                <div class="inpsm">
                    <input id="sm" type="submit" value="Save" />
                </div>
                <div class="an">
                    <h4><%=done%></h4>
                </div>
            </form>
        </div>
    </body>
</html>
