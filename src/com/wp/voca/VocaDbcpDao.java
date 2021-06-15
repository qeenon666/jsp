package com.wp.voca;

import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class VocaDbcpDao extends VocaDao {

	private String dbcpResourceName;
	public VocaDbcpDao(String dbcpResourceName) {
		this.dbcpResourceName = dbcpResourceName;
	}
	protected void connectDB() throws SQLException {
		try {

//			Context initCtx = new InitialContext();
//			Context envCtx = (Context)initCtx.lookup("java:comp/env");
//			DataSource ds = (DataSource)envCtx.lookup(dbcpResourceName);
			
			DataSource ds = (DataSource)(new InitialContext()).lookup("java:comp/env/" + dbcpResourceName);
			conn = ds.getConnection();	
		} catch (NamingException e) {
			throw new SQLException(e);

		}
	}
}