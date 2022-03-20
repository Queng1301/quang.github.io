<%-- 
    Document   : guessView
    Created on : Mar 17, 2022, 9:43:36 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%;
            }
            .container{
                background: gainsboro;
                width: 800px;
                height: 400px;
                margin: 50px auto;
                box-shadow: 10px 10px 10px #666;
            }
            .description{
                width: 40%;
                height: 400px;
                margin: auto;
                float: left;
            }
            #p-d{
                margin: 100px 10px 10px 10px;
            }
            #p-d2{
                 margin: 10px 10px 10px 10px;
                font-style: normal; 
            }
            .picture{
                width: 60%;
                float: right;
            }
            #pc{
                width: 480px;
                height:  400px;
            }
            .adv{
                height: 300px;
                margin: 0px 100px 0px 100px;
            }
            .adv-picture{
                margin-left: 220px;
                width: 100px;
                height: 100px;
                float: left;
            }
            #adv-pc{
                width: 100px;
                height: 100px;
                border-radius: 2px;
            }
            .adv-des{
                float: right;
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
        <div class="container">
            <div class="description">
                <p id="p-d">With a location close to the school will make commuting more convenient. At the same time, the motel has just been handed over, so it has been repaired and the interior is still new. In addition, the hostel is equipped with 2 security cameras, ensuring the safety of students.
                </p>
                <p id="p-d2">Address: Back gate of Quynh Nhai Ethnic Minority High School, Muong Giang, Quynh Nhai, Son La</p>
            </div>
            <div class="picture">
                <img id="pc" src="img/DSC_0842.JPG"/>
            </div>
        </div>
        <div class="adv" style="display: flex">
            <div class="adv-picture">
                <img id="adv-pc" src="img/address-icon-png-favpng-nMQmKvv8aWYuJEVJc6m4yEPhh.jpg"/>
            </div>
            <div class="adv-des">
                <p>Near School</p>
            </div>
            <div class="adv-picture">
                <img id="adv-pc" src="img/graphy-logo-handshake-drawing-red-text-line-area-angle-png-clipart.png"/>
            </div>
            <div class="adv-des">
                <p>Safe</p>
            </div>
            <div class="adv-picture">
                <img id="adv-pc" src="img/computer-icons-money-cash-scalable-vector-graphics-png-favpng-sCCRNhixyeYthjNmMqRi0iXsi.jpg"/>
            </div>
            <div class="adv-des">
                <p>Cheap</p>
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
