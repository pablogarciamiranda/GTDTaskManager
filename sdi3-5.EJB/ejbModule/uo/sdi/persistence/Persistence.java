package uo.sdi.persistence;

import uo.sdi.persistence.impl.CategoryDaoJdbcImpl;
import uo.sdi.persistence.impl.TaskDaoJdbcImpl;
import uo.sdi.persistence.impl.UserDaoJdbcImpl;

public class Persistence implements PersistenceFactory {

	@Override
	public UserDao getUserDao() {
		return new UserDaoJdbcImpl();
	}

	@Override
	public TaskDao getTaskDao() {
		return new TaskDaoJdbcImpl();
	}

	@Override
	public CategoryDao getCategoryDao() {
		return new CategoryDaoJdbcImpl();
	}

}
