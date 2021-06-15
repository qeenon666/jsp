package com.wp.voca;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public abstract class VocamemberDao {
	protected Connection conn = null;
	protected abstract void connectDB() throws SQLException;
	protected void disconnectDB() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}	
	}

	public List<VocamemberDO> getVocamemberList() throws SQLException {
		ArrayList<VocamemberDO> vocamemberList = null;
		connectDB();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from vocamember order by id";
			rs = stmt.executeQuery(sql);
			
			if (rs.isBeforeFirst()) {
				vocamemberList = new ArrayList<VocamemberDO>();
				while (rs.next()) {
					VocamemberDO vocamember = new VocamemberDO();
					vocamember.setId(rs.getString("id"));
					vocamember.setPasswd(rs.getString("passwd"));
					vocamember.setName(rs.getString("name"));
					vocamember.setA1(rs.getInt("a1"));
					vocamember.setA2(rs.getInt("a2"));
					vocamember.setA3(rs.getInt("a3"));
					vocamember.setA4(rs.getInt("a4"));
					vocamember.setA5(rs.getInt("a5"));
					vocamember.setA6(rs.getInt("a6"));
					vocamember.setA7(rs.getInt("a7"));
					vocamember.setA8(rs.getInt("a8"));
					vocamember.setA9(rs.getInt("a9"));
					vocamember.setA10(rs.getInt("a10"));
					vocamember.setA11(rs.getInt("a11"));
					vocamember.setA12(rs.getInt("a12"));
					vocamember.setA13(rs.getInt("a13"));
					vocamember.setA14(rs.getInt("a14"));
					vocamember.setA15(rs.getInt("a15"));
					vocamember.setTotal(rs.getInt("total"));
					vocamember.setTotal2(rs.getInt("total2"));
					vocamember.setTotal3(rs.getInt("totla3"));
					vocamemberList.add(vocamember);
				}
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return vocamemberList;
	}
	public VocamemberDO getVocamember(String id) throws SQLException {
		VocamemberDO vocamember = null;
		connectDB();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from vocamember where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vocamember = new VocamemberDO();
				vocamember.setId(rs.getString("id"));
				vocamember.setPasswd(rs.getString("passwd"));
				vocamember.setName(rs.getString("name"));
				vocamember.setA1(rs.getInt("a1"));
				vocamember.setA2(rs.getInt("a2"));
				vocamember.setA3(rs.getInt("a3"));
				vocamember.setA4(rs.getInt("a4"));
				vocamember.setA5(rs.getInt("a5"));
				vocamember.setA6(rs.getInt("a6"));
				vocamember.setA7(rs.getInt("a7"));
				vocamember.setA8(rs.getInt("a8"));
				vocamember.setA9(rs.getInt("a9"));
				vocamember.setA10(rs.getInt("a10"));
				vocamember.setA11(rs.getInt("a11"));
				vocamember.setA12(rs.getInt("a12"));
				vocamember.setA13(rs.getInt("a13"));
				vocamember.setA14(rs.getInt("a14"));
				vocamember.setA15(rs.getInt("a15"));
				vocamember.setTotal(rs.getInt("total"));
				vocamember.setTotal2(rs.getInt("total2"));
				vocamember.setTotal3(rs.getInt("totla3"));
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return vocamember;
	}

	public int insertVocamember(VocamemberDO vocamember) throws SQLException {
		connectDB();
		int result = 0;
		PreparedStatement stmt = null;
		try {	
			String sql = "insert into vocamember(id, passwd, name) values (?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vocamember.getId());
			stmt.setString(2, vocamember.getPasswd());
			stmt.setString(3, vocamember.getName());
			result = stmt.executeUpdate();		
		} catch(SQLException e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return result;
	}
	public int updateVocamember(VocamemberDO vocamember) throws SQLException {
		connectDB();
		int result = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update vocamember set a1=?, a2=?, a3=?, a4=?, a5=?, a6=?, a7=?, a8=?, a9=?, a10=?, a11=?, a12=?, a13=?, a14=?, a15=? where id=?");
			stmt.setInt(1, vocamember.getA1());
			stmt.setInt(2, vocamember.getA2());
			stmt.setInt(3, vocamember.getA3());
			stmt.setInt(4, vocamember.getA4());
			stmt.setInt(5, vocamember.getA5());
			stmt.setInt(6, vocamember.getA6());
			stmt.setInt(7, vocamember.getA7());
			stmt.setInt(8, vocamember.getA8());
			stmt.setInt(9, vocamember.getA9());
			stmt.setInt(10, vocamember.getA10());
			stmt.setInt(11, vocamember.getA11());
			stmt.setInt(12, vocamember.getA12());
			stmt.setInt(13, vocamember.getA13());
			stmt.setInt(14, vocamember.getA14());
			stmt.setInt(15, vocamember.getA15());
			stmt.setString(16, vocamember.getId());
			stmt.executeUpdate();
	} catch(SQLException e) {
		throw e;
	} finally {
		if (stmt != null) stmt.close();
		disconnectDB();
	}
	return result;
	}
	public int deleteVocamember(String id) throws SQLException {
		connectDB();
		int result = 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = String.format("delete from vocamember where id='%s'", id);
			result = stmt.executeUpdate(sql);
		} catch(SQLException e) {
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return result;
	}
}