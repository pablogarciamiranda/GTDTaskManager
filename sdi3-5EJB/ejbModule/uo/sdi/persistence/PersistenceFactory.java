package uo.sdi.persistence;

public interface PersistenceFactory {
	
	Transaction newTransaction();
	UserDao getUserDao();
	TaskDao getTaskDao();
	CategoryDao getCategoryDao();

}
