<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.DataBase, project.Beans, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Member</title>
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
    <div class="container col-6" style="border: solid; margin-top: 15%;">
        <form action="http://localhost:8080/project_comment/Comment" method="post">
            <ul style="list-style: none;">
                <%
                    String account= (String)session.getAttribute("account");
                    String passwd= (String)session.getAttribute("passwd");
                    Beans beans= new Beans();
                    beans.setAccount(account);
                    beans.setPasswd(passwd);
                    DataBase dataBase= new DataBase();
                    ArrayList<String> data= new ArrayList<String>();
                    data= dataBase.showData(beans);
                %>
                <li>
                    <%out.print("<span style='font-size: 1.3rem;'>會員帳號: "+data.get(0)+"</span>"); %>
                </li>
                <li>
                    <%out.print("<span style='font-size: 1.3rem;'>會員密碼: "+data.get(1)+"</span>"); %>
                </li>
                <li>
                    <%out.print("<span style='font-size: 1.3rem;'>電子郵件: "+data.get(2)+"</span>"); %>
                </li>
                <li>
                    <%out.print("<span style='font-size: 1.3rem;'>手機號碼: "+data.get(3)+"</span>"); %>
                </li>
                <li>
                    <span style="font-size: 1.3rem;">照片網誌</span>
                    <input class="ms-5" type="text" name="url" id="url">
                </li>
                <li>
                    <span style="font-size: 1.3rem;">評論</span>
                    <input class="ms-5" type="text" name="comment" id="comment">
                </li>
            </ul>
            <div>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </div>
            
        </form>
    </div>
</body>
</html>