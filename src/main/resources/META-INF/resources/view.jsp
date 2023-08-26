<%@ include file="/init.jsp" %>


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

<liferay-portlet:renderURL var="addStudentURL">
    <liferay-portlet:param name="jspPage" value="/add_student.jsp" />
</liferay-portlet:renderURL>


<a id="addStudentLink" href="${addStudentURL}"> 
	<button id="addStudentButton"> Aggiungi Studente </button>
</a> 




