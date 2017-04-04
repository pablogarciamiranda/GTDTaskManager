package uo.sdi.business.impl.util;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.infraestructure.Factories;

public class TaskCheck {

	public static void categoryExists(Task task) throws BusinessException {
		Category c = Factories.persistence.getCategoryDao().findById( task.getCategoryId());
		BusinessCheck.isNotNull( c, MessageProvider.getValue("categoryExists"));
	}

	public static void userExists(Task task) throws BusinessException {
		User u = Factories.persistence.getUserDao().findById( task.getUserId());
		BusinessCheck.isNotNull( u, MessageProvider.getValue("userExists"));
	}

	public static void userIsNotDisabled(Task task) throws BusinessException {
		User u = Factories.persistence.getUserDao().findById( task.getUserId());
		BusinessCheck.isTrue( u.getStatus().equals( UserStatus.ENABLED), 
				MessageProvider.getValue("userIsNotDisabled"));
	}

	public static void userIsNotAdmin(Task task) throws BusinessException {
		User u = Factories.persistence.getUserDao().findById( task.getUserId());
		BusinessCheck.isFalse( u.getIsAdmin(), 
				MessageProvider.getValue("userIsNotAdmin"));
	}

	public static void titleIsNotNull(Task task) throws BusinessException {
		BusinessCheck.isTrue( task.getTitle() != null, 
				MessageProvider.getValue("titleIsNotNull"));
	}

	public static void titleIsNotEmpty(Task task) throws BusinessException {
		BusinessCheck.isTrue( ! "".equals( task.getTitle() ), 
				MessageProvider.getValue("titleIsNotEmpty"));
	}

}
