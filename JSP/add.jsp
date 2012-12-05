<%-- 
    Document   : add
    Created on : Dec 4, 2012, 7:28:42 PM
    Author     : Team ParaGoomba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Administrator Page | Add</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css"  href="./css/text.css">
    <link rel="stylesheet" type="text/css"  href="./css/960_12_col.css">
    <link rel="stylesheet" type="text/css"  href="./css/mystyle.css">
</head>
<body>
<%@ page import="db_objects.Mentor, java.util.ArrayList"%>
<%
    String message = (String) request.getAttribute("message");
    if(message == null)
    {
        message = "";
    }
%>
<div class="container_12">
    <div class="header_mentor">
    <div class="grid_12">
        <h1 class="head">
            CIS Mentors : Admin Page
        </h1>
    </div>
    </div>
<% if((String)session.getAttribute("admin_name") != null) { %>
<div class ="grid_8">
        <h2>Welcome <%= (String) session.getAttribute("admin_name") %> <%=message%></h2>
</div>
<div class="clear"></div> 
<div class="grid_2"></div>
<div class="grid_2">
</div>
<div class="clear"></div>
<form id="mentorInfo" action="AddServlet" method="post">
    <div class="grid_2">
        <img src="./images/no_image.jpg" alt="new user"><br>
        <p>
        Image name:<br>
        <input type="text" name="img" value="no_image.jpg"> <br>
        WARNING! <br>
        (You must upload your image to the server in web/images before your picture will show.)
        </p>
    </div>
    <div class="grid_2">
        <h3 id="mentorname">
        Name:<br>
        <input type="text" name="name">
        </h3>
    </div>
        
    <div class="grid_4">
        <b>Areas Of Expertise:</b>
        <div id="expertise">
            <textarea name ="qual" cols="20" rows="10"></textarea> 
            <p>WARNING!<br>
            Always put a comma and space after each Area of Expertise.
            </p>
        </div>
    </div>
        
    <div class="grid_3">
        <b>Contact Information</b>
        <div id="contact">
        <p>
        Email:<br>
        <input type="text" name="email"><br><br>
        Comments:<br>
        <textarea name ="comment" cols="20" rows="10"></textarea>
        </p>
        </div>
    </div>
 <div class="clear"></div>       
   
<div class="grid_8"></div>
<div class="grid_2">
    <input type="submit" name="submit" value="Add">
    <input type="submit" name="submit" value="Cancel">
</div>
</form>
<div class="clear"></div>
<%} else {%>
<div class ="grid_4">
    <h3>Welcome Guest</h3>
    <p>
        I'm sorry. You are not authorized to view this page.<br>
        If you are an administrator try logging in first.
    </p>
</div> 
<%}%>
</div>
</body>
</html>
