<%-- 
    Document   : index
    Created on : Nov 21, 2012, 11:41:26 AM
    Author     : Team ParaGoomba
--%>

<%@page import="mysql.MentorIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CIS Mentors</title>
<link rel="stylesheet" type="text/css" href="./css/reset.css">
<link rel="stylesheet" type="text/css"  href="./css/text.css">
<link rel="stylesheet" type="text/css"  href="./css/960_12_col.css">
<link rel="stylesheet" type="text/css"  href="./css/mystyle.css">
</head>
<body>
<%@ page import="db_objects.Mentor, java.util.ArrayList"%>
<%
    String message = "";
    if((String) request.getAttribute("message") != null)
    {
        message = (String) request.getAttribute("message");
    }
%>
<div class="container_12">
	<div class="header_mentor">
	<div class="grid_6">
            <h1 class="head">
            CIS Mentors
            </h1>
	</div>
        <div id="login">
        <div class="grid_5">
        <form action="LoginServlet" method="post">
            <p><input type="text" name="admin_name"> Admin</p>
            <p><input type="password" name="admin_pw"> Password  
            <input type="submit" value="Login"> <%= message%></p> 
        </form>
        </div>
        </div>
        <div class="clear"></div>
</div>



<!-- Copy beginning here -->
<%
    ArrayList<Mentor> mentors = MentorIO.listMentors();
    for(Mentor m: mentors) {
%>
        <div id="mentorInfo">
            <div class="grid_4">
                <h2 id="mentorname"><img src="./images/<%=m.getImg()%>" alt="<%=m.getName()%>">
                <%=m.getName()%>
                </h2>
            </div>
            <div class="grid_4">
                <b>Areas Of Expertise:</b>
                <p id="expertise">
                    <%=m.getQual()%>
                </p>
            </div>
            <div class="grid_3">
                <b>Contact Information</b>
                <ul id="contact">
                    <li><%=m.getEmail()%></li>
                    <br><%=m.getComment()%>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
<%}%>
<!-- End Copy Here -->

</div>
</body>
</html>