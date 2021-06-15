package com.wp.voca;

import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class VocamemberDbcpDao extends VocamemberDao {

	private String dbcpResourceName;
	public VocamemberDbcpDao(String dbcpResourceName) {
		this.dbcpResourceName = dbcpResourceName;
	}
	protected void connectDB() throws SQLException {
		try {
			DataSource ds = (DataSource)(new InitialContext()).lookup("java:comp/env/" + dbcpResourceName);
			conn = ds.getConnection();	
		} catch (NamingException e) {
			throw new SQLException(e);

		}
	}
}