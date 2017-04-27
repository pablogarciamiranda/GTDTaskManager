package uo.sdi.menu;

import uo.sdi.client.RestClient;
import uo.sdi.client.exception.BusinessException;
import uo.sdi.client.service.TaskServicesRest;
import uo.sdi.client.service.UserServicesRest;

/**
 * Representa cada acción invocada por el usuario.
 * 
 * Cada acción se encargará de la interacción con el usuario: pantalla, teclado,
 * listados y validaciones; e invocará a la capa de servicios.
 * 
 * @author alb
 */
public interface Action {
	void execute(UserServicesRest userServiceRest,
			TaskServicesRest taskServicesRest, RestClient client)
			throws BusinessException;
}