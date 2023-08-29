<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />


<portlet:actionURL name="aggiungiStudente" var="aggiungiStudenteURL" />

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
    <portlet:param name="redirect" value="${currentURL}" />
    <!-- Altri parametri aggiuntivi, se necessario -->
</portlet:renderURL>

<h1> Form aggiunta studenti </h1>


<aui:form action="<%= aggiungiStudenteURL %>" name="addStudentForm" method="post">
    
	    
	    <aui:input label="Name" name="name" type="text" required="true"/>
	    <aui:input label="Surname" name="surname" type="text" required="true"/>
	    <aui:input label="Age" name="age" type="text" required="true"/>
		<aui:input label="Address" name="address" type="text" required="true"/>
	
	<aui:button-row>	
	    
	    <aui:button type="submit" value="Aggiungi Studente"> </aui:button>
	   	<aui:button type="cancel" href="${viewURL}" > </aui:button>
	
	</aui:button-row>
</aui:form>

