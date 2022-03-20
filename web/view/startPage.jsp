<%-- 
    Document   : startPage
    Created on : Mar 16, 2022, 10:35:39 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
        <style>
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%; 
            }
            .welcome{
                margin: 0 auto;
                font-family: fantasy;
                width: 450px;
                height: 50px;
                color: white;
                text-align: center;
                text-shadow: 2px 2px black;
            }
            .container{
                margin-top: 70px;
            }
            .clear { clear: both }
            .content {
                background-image: linear-gradient(to bottom right,rgb(96, 201, 175), #50a3a2);
                width: 40%;
                height: 330px;
                border-radius: 10px;
                margin: 0 auto;
                padding: 10px;
                box-shadow: 10px 10px 10px gray;
            }
            .post {
                width: 300px;
                height: 130px;
                font-size: 50px;
                margin-bottom: 60px;   
                text-align: center;
                float: left;
            }
            #ques{   
                font-family: serif;
                margin: auto;              
            }
            .sidebar {
                width: 300px;
                height: 200px;
                background: #b1b1b1;
                float: right;
            }
            .inputBtn{
                width: 150px;
                height: 70px;
                margin-top: 20px;
                margin-left: 80px;
                border-radius: 4px;
                border-color: #50a3a2;
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
    </head>
    <body>
        <div class="welcome">
            <h1>Welcome to La Thoc's Motel Offical Website!</h1>
        </div> 
        <div class="container">
            <div class="content">  
                <div class="post">
                    <h1 id="ques">You are?</h1>
                </div>
                <div class="slidebar">               
                    <form action="start" method="POST">               
                        <input class="inputBtn" type="submit" name="whoLogin" value="Guess"/> </br>
                        <input class="inputBtn" type="submit" name="whoLogin" value="Student"/> </br>
                        <input class="inputBtn" type="submit" name="whoLogin" value="Manager"/> </br>
                    </form>
                </div>
                <div class="clear"></div>
            </div>
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
