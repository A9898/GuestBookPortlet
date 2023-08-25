package com.training.gradebookPortlet.portlet;

import com.training.gradebookPortlet.constants.GradebookPortletKeys;
import com.training.liferay.gradebookservicebuilder.model.Students;
import com.training.liferay.gradebookservicebuilder.service.StudentsLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

 

import org.osgi.service.component.annotations.Component;


/**
 * @author schir
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Gradebook",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)



public class GradebookPortlet extends MVCPortlet {
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException{
		
		String messaggio = "Gradebook Portlet";
		request.setAttribute("messaggio_benvenuto", messaggio);
		
		try {
			Students students = StudentsLocalServiceUtil.getStudents(1);
			request.setAttribute("studentIdZero", students);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Students> listaStudenti = StudentsLocalServiceUtil.getStudentses(0, 100);
		request.setAttribute("listaStudenti", listaStudenti);
		
//		Students studente = students.get(0).getStudent_name();
//		request.setAttribute("studente", studente);
		
		super.doView(request,response);
	}
	
	
	
}







