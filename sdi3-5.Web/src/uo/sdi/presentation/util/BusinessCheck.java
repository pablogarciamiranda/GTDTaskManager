package uo.sdi.presentation.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BusinessCheck {

	public static String showBusinessError(String messg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Error!", messg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		return null;
	}

	public static String showBusinessInfo(String messg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Info!", messg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		return null;
	}

}
