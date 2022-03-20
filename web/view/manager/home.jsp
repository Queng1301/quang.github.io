<%-- 
    Document   : home
    Created on : Mar 18, 2022, 5:32:43 PM
    Author     : Admin
--%>

<%@page import="model.Report"%>
<%@page import="model.Announcement"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.StudentAccount"%>
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
            .row{
                display: flex;
                flex-wrap: wrap;
            }
            .lcol{
                height: 800px;
                flex: 0 0 auto;
                width: 40%; 
            }
            .rcol{
                height: 800px;
                flex: 0 0 auto;
                width: 60%;   
            }
            .col-1{
                flex-shrink: 0;
                width: 100%;
                max-width: 100%;
            }
            .col-2{
                margin-bottom: 1.875rem;
                background-color: #ffffff;
                position: relative;
                border: 0px solid transparent;
                margin: 0px 20px 0px 20px;
                height: 700px;
                letter-spacing: 0.5px; 
                border-radius: 10px;
                box-shadow: 5px 5px 5px #666;
            }
            .col-2-r1{
                margin-bottom: 1.875rem;
                background-color: #ffffff;
                position: relative;
                border: 0px solid transparent;
                margin: 0px 20px 0px 20px;
                height: 335px;
                letter-spacing: 0.5px; 
                border-radius: 10px;
                box-shadow: 5px 5px 5px #666;
            }
            .col-2-r2{
                margin-bottom: 1.875rem;
                background-color: #ffffff;
                position: relative;
                border: 0px solid transparent;
                margin: 0px 20px 0px 20px;
                height: 335px;
                letter-spacing: 0.5px; 
                border-radius: 10px;
                box-shadow: 5px 5px 5px #666;
            }
            .col-3{
                margin: 0px 20px 0px 20px;
            }
            .c-head{
                border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;
            }
            .title{
                margin-bottom: 0px;
                text-transform: capitalize;
                color: #2b2b2b;
                font-size: 22px; 
            }
            .c-body{
                padding: 0px 20px 20px 20px;
            }
            .create-btn{
                padding: 10px 20px 0px 20px;
            }
            .panel{
                max-height: 331px;
                box-shadow: none !important;
                height: auto;
            }
            .list{
                display: flex;
                flex-direction: column;
                padding-left: 0;
                margin-bottom: 0;
                border-radius: 0.25rem;
            }
            .list-item{
                border: none;
                border-bottom: 1px solid #ecf3fa;
                padding: 9px 0;
            }
        </style>
        <%
            ArrayList<StudentAccount> stu = (ArrayList<StudentAccount>) request.getAttribute("stu");
            ArrayList<Announcement> anns = (ArrayList<Announcement>) request.getAttribute("anns");
            ArrayList<Report> rps = (ArrayList<Report>) request.getAttribute("rps");
        %>
    </head>
    <body>
        <div class="row">
            <div class="lcol">
                <div class="col-1">
                    <div class="col-2">
                        <div class="col-3">
                            <div class="c-head">
                                <h4 class="title">Student List</h4>
                            </div>
                            <div class="create-btn">
                                <form action="createStudent" method="GET">
                                    <input type="submit" value="Create New"/>
                                </form>
                            </div>
                            <div class="c-body">
                                <div class="panel">
                                    <ul class="list">
                                        <%for (StudentAccount s : stu) {%>
                                        <li class="list-item">
                                            <div class="std-name">
                                                <%=s.getStudent().getSname()%>
                                            </div>
                                            <div class="std-btn" style="display: flex">
                                                <form action="manageStuData" method="GET">    
                                                    <input hidden="" name="username" value="<%=s.getUsername()%>"/>
                                                    <input hidden="" name="password" value="<%=s.getPassword()%>"/>
                                                    <input id="edit-btn" type="submit" value="Edit Data" />
                                                    <input id="edit-btn" type="submit" value="View Bill"/>
                                                </form>
                                            </div>
                                        </li>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rcol">
                <div class="col-1">
                    <div class="col-2-r1">
                        <div class="col-3">
                            <div class="c-head">
                                <h4 class="title">Announcement</h4>
                            </div>
                            <div class="c-body">
                                <ul class="list">
                                    <%for (Announcement a : anns) {%>
                                    <li class="list-item"> <%=a.getTitle()%></li>
                                        <%}%>
                                </ul>
                            </div>
                            <div class="create-btn">
                                <form>
                                    <input type="submit" value="Create New"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-2-r2">
                        <div class="col-3">
                            <div class="c-head">
                                <h4 class="title">Report</h4>
                            </div>
                            <div class="c-body">
                                <ul class="list">
                                    <%for (Report r : rps) {%>
                                    <li class="list-item"><%=r.getTitle()%></li>
                                        <%}%>
                                </ul>
                            </div>
                            <div class="create-btn">
                                <form>
                                    <input type="submit" value="Create New"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>           
        </div>
    </body>
</html>
