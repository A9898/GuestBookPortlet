package com.training.gradebookPortlet.portlet;

import com.training.gradebookPortlet.constants.GradebookPortletKeys;
import com.training.liferay.gradebookservicebuilder.model.Students;
import com.training.liferay.gradebookservicebuilder.service.StudentsLocalService;
import java.io.IOException;
import java.util.List;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

 

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


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
	
	@Reference
	private StudentsLocalService studentsLocalService;
	 
	
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException{
		
		String messaggio = "Lista Studenti";
		request.setAttribute("messaggio_benvenuto", messaggio);
		
		
		List<Students> listaStudenti = studentsLocalService.getStudentses(0, 100);
		request.setAttribute("listaStudenti", listaStudenti);
		
		super.doView(request,response);
	}
	
	  public void aggiungiStudente(ActionRequest actionRequest, ActionResponse actionResponse)
	            throws IOException, PortletException {
		  	
		  	// Raccogli i dati inseriti nel form 
		  	String uuid = ParamUtil.getString(actionRequest, "uuid");
	        String name = ParamUtil.getString(actionRequest, "name");
	        String surname = ParamUtil.getString(actionRequest, "surname");
	        String age = ParamUtil.getString(actionRequest, "age");
	        String address = ParamUtil.getString(actionRequest, "address");
	       
	        // Esegui l'azione per aggiungere il nuovo studente al database
	        try {
	        	studentsLocalService.addStudents(uuid, name, surname, age, address);
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }	  
	  
	  
}










