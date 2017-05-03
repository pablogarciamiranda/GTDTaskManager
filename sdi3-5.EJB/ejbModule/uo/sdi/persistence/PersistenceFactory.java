package uo.sdi.persistence;

public interface PersistenceFactory {
	
	UserDao getUserDao();

	TaskDao getTaskDao();

	CategoryDao getCategoryDao();

}
