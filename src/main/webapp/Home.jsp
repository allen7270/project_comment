<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.DataBase, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="Home.html">Home</a>
            <div class="navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="Login.html">Login</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="Register.html">Register</a>
                </li>
            </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        <div class="row row-cols-1 row-cols-md-2 g-4">
            <%
            	DataBase dataBase= new DataBase();
            	ArrayList<String> data= dataBase.home();
            	int dataCol= 3;
            	int dataCount= data.size()/dataCol;
            %>
            <%
            	for(int i=0; i<dataCount; i++){
            		out.print("<div class='col'><div class='card'>");
            		out.print("<img src='"+data.get(1+i*dataCol)+"' class='card-img-top'>");
            		out.print("<div class='card-body'><h5 class='card-title'>"+data.get(0+i*dataCol)+"</h5>");
            		out.print("<p class=card-text'>"+data.get(2+i*dataCol)+"</p>");
            		out.print("</div></div></div>");
            	}
            %>
        </div>
    </div>
</body>
</html>