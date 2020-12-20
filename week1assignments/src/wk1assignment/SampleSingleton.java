/**
 * 
 */
package wk1assignment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author matthew
 *
 */
public class SampleSingleton {
	private static Connection conn = null;
	private static SampleSingleton instance = null;

	private SampleSingleton() {
	};

	/*
	 * Our main change is to check whether instance is null,
	 * and if it is, to construct and instance.
	 * 
	 * (This is not thread safe so we could also synchronize
	 * if this will be used in multithreaded situations.)
	 */
	public static SampleSingleton getInstance() {
		if (instance == null) {
			instance = new SampleSingleton();
		}
		return instance;
	}

	public static void databaseQuery(BigDecimal input) throws SQLException {
		conn = DriverManager.getConnection("url of database");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from table");
		int x = 0;
		while (rs.next()) {
			x = rs.getInt(1) * input.intValue();
		}
	}
}