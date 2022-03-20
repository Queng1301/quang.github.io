<%-- 
    Document   : home
    Created on : Mar 17, 2022, 3:15:20 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Announcement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%
            ArrayList<Announcement> anns = (ArrayList<Announcement>) request.getAttribute("anns");
        %>
        <style>   
            header{
                position: absolute;
                left: 0;
                right: 0;
                top: 0;
                background: grey;
                width: 100%;
                height: 80px;
            }
            .nav{
                
            }
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%;
            }
            .ancontainer{
                background-color: whitesmoke ;
                margin: 100px auto 10px auto;
                width: 50%;
                height: 300px;
                border-radius: 10px;
            }
            .buttoncontainer{
                margin: 40px 40% auto 26%;
            }
            .button{
                width: 150px;
                height: 150px;
                margin-left: 70px;
                border-radius: 5px;
                text-align: center;
            }
            .announcement{
                background: wheat;             
            }
            .ula{
                
            }
            .footer-content h2{
                font-size: 2.1rem;
                font-weight: 500;
                text-transform: capitalize;
                line-height: 3rem;
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
            .footer-content{
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                text-align: center;
            }
            .footer-content p{
                max-width: 500px;
                margin: 10px auto;
                line-height: 5px;
                font-size: 14px;
                color: #cacdd2;
                text-align: center;
            }
        </style>
        <script>

        </script>
    </head>
    <body>
        <header class="header">
            <nav class="nav">
                <ul>
                    <li><a href="#">Manage Account</a></li>
                    <li><a href="#">Logout</a></li>
                </ul>
            </nav>
        </header>
        <div class="ancontainer">
            <div class="announcement">
                <h3>Announcements</h3>
                <table border ="1px">
                    <%for (Announcement a : anns) {%>
                    <ul class="ula">
                        <li><%=a.getTitle()%></li>
                        <li><%=a.getContent()%></li>
                        <li><%=a.getTime()%></li>
                    </ul>
                    <%}%>
                </table>
            </div>
        </div>
        <div class="buttoncontainer" style="display: flex"> 
            <form action="stuData" method="GET">
                <button class="button" type="submit">Check Your Information</button>
            </form>
            <form action="bill" method="GET">
                <button class="button" type="submit">Check Your Bills</button>
            </form>
            <form action="stuReport" method="GET">
                <button class="button" type="submit">Report Problem</button>
            </form>
        </div>

        <footer>
            <div class="footer-content">                                        
                <ul>
                    <p>Contact us</p> 
                    <p>Phone number: 0365302112</p>
                    <p>Email: havanlack@gmail.com</p>
                    <p>Facebook: <a href="https://www.facebook.com/ha.vanla"> Ha Van La</a></p>
                </ul>
            </div> 
        </footer>
    </body>
</html>
