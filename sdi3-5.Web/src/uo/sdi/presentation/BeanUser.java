package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;
import uo.sdi.presentation.util.BusinessCheck;
import uo.sdi.presentation.util.MessageProvider;
import alb.util.log.Log;

/**
 * ManagedBean to manage the actions of the user
 *
 * @author Pablo and Fernando
 * 
 */
@ManagedBean(name = "user")
@RequestScoped
public class BeanUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String email;
	private String password;
	private String repeatPassword;

	/**
	 * Through this method the user is registered in the system.
	 * 
	 * @return String containing the next view to show
	 */
	public String signUp() {
		UserService userService = Factories.services.getUserService();
		User user = null;
		try {
			user = userService.findLoggableUser(getLogin());
		} catch (BusinessException b) {
			Log.debug(b);
			BusinessCheck.showBusinessError(b.getMessage());
			return null;
		}
		// If user is already registered.
		if (user != null) {
			Log.debug("User " + login + " is already registered");
			BusinessCheck.showBusinessError(MessageProvider
					.getValue("userAlreadyExist"));
			return null;
		}
		// Otherwise, save the user in the db.
		User cloneUser = new User();
		cloneUser.setEmail(getEmail());
		cloneUser.setLogin(getLogin());
		cloneUser.setPassword(getPassword());
		try {
			userService.registerUser(cloneUser);
			Log.debug("New user " + user + " successfully registered");
			BusinessCheck.showBusinessInfo(MessageProvider
					.getValue("registerOk"));
		} catch (BusinessException b) {
			Log.debug(b);
			BusinessCheck.showBusinessError(b.getMessage());
			return null;
		}
		return "exito";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

}
