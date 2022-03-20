<%-- 
    Document   : bill
    Created on : Mar 17, 2022, 3:15:35 PM
    Author     : Admin
--%>

<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.StudentAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill Page</title>
        <style>
            body{
                background-image: linear-gradient(to right, #50a3a2,rgb(96, 201, 175));
                background-position: center center; 
                background-size: 100% 500%;
            }
            .container{
                background-color: whitesmoke;
                width: 400px;
                height: 400px;
                margin: 100px auto;
                border-radius: 10px;
                box-shadow: 10px 10px 10px gray;           
            }
            .table{
                margin: 30px auto;  
            }
        </style>
        <%
            ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
        %>
    </head>
    <body>
        <div class="container">
            <table class="table" border="3px">
                <tr>
                    <td>Month</td>
                    <td>Electric</td>
                    <td>Water</td>
                    <td>Reduce</td>
                    <td>Total</td>
                    <td>Paid</td>
                </tr>
                <%for (Bill b : bills) {%>
                <tr>
                    <%float total = b.getElectric() + b.getWater();%>
                    <td><%=b.getMonth()%></td>
                    <td><%=b.getElectric()%></td>
                    <td><%=b.getWater()%></td>
                    <td><%=b.getReduce()%></td>
                    <td><%=total%></td>
                    <td><input type="checkbox" value="true"></td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
