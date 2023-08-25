<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.training.liferay.gradebookservicebuilder.model.Students" %>


<% Students studentIdZero = (Students) request.getAttribute("studentIdZero"); %>
<% List<Students> listaStudenti = (List) request.getAttribute("listaStudenti"); %>


<h1>${messaggio_benvenuto}</h1>

<br>

 <table id=student_table>
 
  <tr>
    <th>idStudent</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Age</th>
    <th>Address</th>
  </tr>
  
  
  <c:forEach items="${listaStudenti}" var="student">
  
  <tr>
    <td>${student.getStudent_id()}</td>
    <td>${student.getStudent_name()}</td>
    <td>${student.getStudent_surname()}</td>
    <td>${student.getStudent_age()}</td>
    <td>${student.getStudent_address()}</td>
  </tr>
  
 </c:forEach>
</table> 
