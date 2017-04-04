package uo.sdi.persistence.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import uo.sdi.persistence.PersistenceException;

public class JdbcHelper {

	private static Properties properties;

	public JdbcHelper(String configFile) {
		properties = new Properties();
		try {
			properties.load(JdbcHelper.class.getResourceAsStream(configFile));
		} catch (IOException e) {
			throw new RuntimeException("Properties file not found: "
					+ configFile);
		}
	}

	public Connection createConnection() {

		/*
		 * Obtenemos la conexi�n a la base de datos con un Datasource El
		 * Datasource es una factoria de conexiones. Las conexiones as�
		 * obtenidas son gestionadas por el contenedor y ello hace que todo el
		 * SQL que se ejecute quede dentro de una transacci�n
		 */
		try {
			String jndiKey = getProperty("JNDI_DATASOURCE");

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(jndiKey);
			return ds.getConnection();

		} catch (NamingException e) {
			throw new RuntimeException("Can't open JDBC conection from JNDI", e);
		} catch (SQLException e) {
			throw new RuntimeException("Can't open JDBC conection", e);
		}
	}

	private static String getProperty(String property) {
		String value = properties.getProperty(property);
		if (value == null) {
			throw new RuntimeException("Property not found " + property);
		}
		return value;
	}

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	public Connection getCurrentConnection() {
		Connection con = threadLocal.get();
		if (con == null) {
			con = createConnection();
		}
		return con;
	}

	public String getSqlQuery(String sql) {
		return getProperty(sql);
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection con) {
		close(rs);
		close(ps);
		close(con);
	}

	public void close(PreparedStatement ps, Connection con) {
		close(ps);
		close(con);
	}

	void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
			}
		}
		;
	}

	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
			}
		}
		;
	}

	/**
	 * If not using a Transaction object, a call to this method physically
	 * closes the connection (each call to a Dao method is in its own
	 * transaction).
	 * 
	 * If there is a Transaction open, then this method does nothing as the
	 * Transaction itself will close the connection by calling commit or
	 * rollback
	 * 
	 * @param con
	 */
	public void close(Connection con) {
		if (!isInAutoCommitMode(con))
			return; // Transaction is in charge

		threadLocal.set(null);
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
			}
		}
		;
	}

	private static boolean isInAutoCommitMode(Connection con) {
		try {
			return con.getAutoCommit();
		} catch (SQLException e) {
			throw new PersistenceException("Unexpected exception", e);
		}
	}

}
