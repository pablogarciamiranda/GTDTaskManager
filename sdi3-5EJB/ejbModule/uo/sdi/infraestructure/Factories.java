package uo.sdi.infraestructure;

import uo.sdi.business.ServicesFactory;
import uo.sdi.business.impl.LocalEJBServicesLocator;
import uo.sdi.persistence.Persistence;
import uo.sdi.persistence.PersistenceFactory;

public class Factories {

	public static ServicesFactory services = new LocalEJBServicesLocator();
	public static PersistenceFactory persistence = new Persistence();

}