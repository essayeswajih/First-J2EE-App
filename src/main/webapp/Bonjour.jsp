<%@ page import="com.example.frist_j2ee_app.models.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wajih
  Date: 3/1/2024
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bonjour</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp"%>
    <h1>Page Bonjour</h1>
    <%
        String Message = (String) request.getAttribute("Message");
        out.print(Message);
    %>
    <h3>
        ${ StudentCount}
    </h3>
    <form method="post" >
        <label for="Nom">Name : </label><br>
        <input type="text" name="Nom" id="Nom" placeholder="Your Name" class="form-group"/><br>
        <input type="text" name="Age" id="Age" placeholder="Your Age" class="form-group"/><br>
        <br>
        <input type="submit" class="btn btn-primary" value="Add" />
    </form>
    <br>
    <br>
    <h3>
        <%
            Integer studentCountObj = (Integer) request.getAttribute("StudentCount");
            int studentCount = (studentCountObj != null) ? studentCountObj.intValue() : 0;

            out.print("<table class='table table-striped'>");
            out.print("<tr>");
            out.print("<th>Id</th>");
            out.print("<th>Nom</th>");
            out.print("<th>Age</th>");
            out.print("</tr>");
            List<Student> listStudent = (List<Student>) request.getAttribute("Students");
            if(listStudent!=null){
                for(Student s : listStudent){
                    out.print("<tr>");
                    out.print("<td>"+s.getId()+"#</td>");
                    out.print("<td>"+s.getName()+"</td>");
                    out.print("<td>"+s.getAge()+"</td>");
                    out.print("</tr>");
                }
            }
            else{
                System.out.print(listStudent);
            }
            out.print("</table>");
        %>
    </h3>
</div>


</body>
</html>
