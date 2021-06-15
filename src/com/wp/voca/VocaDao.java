package com.wp.voca;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public abstract class VocaDao {
	protected Connection conn = null;
	protected abstract void connectDB() throws SQLException;
	protected void disconnectDB() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}	
	}

	public List<VocaDO> getVocaList() throws SQLException {
		ArrayList<VocaDO> memberList = null;
		connectDB();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from voca";
			rs = stmt.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				memberList = new ArrayList<VocaDO>();
				while (rs.next()) {
					VocaDO member = new VocaDO();
					member.setT1(rs.getString("t1"));
					member.setT2(rs.getString("t2"));
					member.setT3(rs.getString("t3"));
					member.setT4(rs.getString("t4"));
					member.setT5(rs.getString("t5"));
					member.setT6(rs.getString("t6"));
					member.setT7(rs.getString("t7"));
					member.setT8(rs.getString("t8"));
					member.setT9(rs.getString("t9"));
					member.setT10(rs.getString("t10"));
					member.setT11(rs.getString("t11"));
					member.setT12(rs.getString("t12"));
					member.setT13(rs.getString("t13"));
					member.setT14(rs.getString("t14"));
					member.setT15(rs.getString("t15"));
					member.setT16(rs.getString("t16"));
					member.setT17(rs.getString("t17"));
					member.setT18(rs.getString("t18"));
					member.setT19(rs.getString("t19"));
					member.setT20(rs.getString("t20"));
					member.setT21(rs.getString("t21"));
					member.setT22(rs.getString("t22"));
					member.setT23(rs.getString("t23"));
					member.setT24(rs.getString("t24"));
					member.setT25(rs.getString("t25"));
					member.setT26(rs.getString("t26"));
					member.setT27(rs.getString("t27"));
					member.setT28(rs.getString("t28"));
					member.setT29(rs.getString("t29"));
					member.setT30(rs.getString("t30"));
					member.setT31(rs.getString("t31"));
					member.setT32(rs.getString("t32"));
					member.setT33(rs.getString("t33"));
					member.setT34(rs.getString("t34"));
					member.setT35(rs.getString("t35"));
					member.setT36(rs.getString("t36"));
					member.setT37(rs.getString("t37"));
					member.setT38(rs.getString("t38"));
					member.setT39(rs.getString("t39"));
					member.setT40(rs.getString("t40"));
					member.setT41(rs.getString("t41"));
					member.setT42(rs.getString("t42"));
					member.setT43(rs.getString("t43"));
					member.setT44(rs.getString("t44"));
					member.setT45(rs.getString("t45"));
					member.setT46(rs.getString("t46"));
					member.setT47(rs.getString("t47"));
					member.setT48(rs.getString("t48"));
					member.setT49(rs.getString("t49"));
					member.setT50(rs.getString("t50"));
					member.setT51(rs.getString("t51"));
					member.setT52(rs.getString("t52"));
					member.setT53(rs.getString("t53"));
					member.setT54(rs.getString("t54"));
					member.setT55(rs.getString("t55"));
					member.setT56(rs.getString("t56"));
					member.setT57(rs.getString("t57"));
					member.setT58(rs.getString("t58"));
					member.setT59(rs.getString("t59"));
					member.setT60(rs.getString("t60"));
					member.setT61(rs.getString("t61"));
					member.setT62(rs.getString("t62"));
					member.setT63(rs.getString("t63"));
					member.setT64(rs.getString("t64"));
					member.setT65(rs.getString("t65"));
					member.setT66(rs.getString("t66"));
					member.setT67(rs.getString("t67"));
					member.setT68(rs.getString("t68"));
					member.setT69(rs.getString("t69"));
					member.setT70(rs.getString("t70"));
					member.setT71(rs.getString("t71"));
					member.setT72(rs.getString("t72"));
					member.setT73(rs.getString("t73"));
					member.setT74(rs.getString("t74"));
					member.setT75(rs.getString("t75"));
					memberList.add(member);
				}
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return memberList;
	}
	public VocaDO getMember(String t1) throws SQLException {
		VocaDO member = null;
		connectDB();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from voca";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, t1);
			rs = stmt.executeQuery();

			if (rs.next()) {
				member = new VocaDO();
				member.setT1(rs.getString("t1"));
				member.setT2(rs.getString("t2"));
				member.setT3(rs.getString("t3"));
				member.setT4(rs.getString("t4"));
				member.setT5(rs.getString("t5"));
				member.setT6(rs.getString("t6"));
				member.setT7(rs.getString("t7"));
				member.setT8(rs.getString("t8"));
				member.setT9(rs.getString("t9"));
				member.setT10(rs.getString("t10"));
				member.setT11(rs.getString("t11"));
				member.setT12(rs.getString("t12"));
				member.setT13(rs.getString("t13"));
				member.setT14(rs.getString("t14"));
				member.setT15(rs.getString("t15"));
				member.setT16(rs.getString("t16"));
				member.setT17(rs.getString("t17"));
				member.setT18(rs.getString("t18"));
				member.setT19(rs.getString("t19"));
				member.setT20(rs.getString("t20"));
				member.setT21(rs.getString("t21"));
				member.setT22(rs.getString("t22"));
				member.setT23(rs.getString("t23"));
				member.setT24(rs.getString("t24"));
				member.setT25(rs.getString("t25"));
				member.setT26(rs.getString("t26"));
				member.setT27(rs.getString("t27"));
				member.setT28(rs.getString("t28"));
				member.setT29(rs.getString("t29"));
				member.setT30(rs.getString("t30"));
				member.setT31(rs.getString("t31"));
				member.setT32(rs.getString("t32"));
				member.setT33(rs.getString("t33"));
				member.setT34(rs.getString("t34"));
				member.setT35(rs.getString("t35"));
				member.setT36(rs.getString("t36"));
				member.setT37(rs.getString("t37"));
				member.setT38(rs.getString("t38"));
				member.setT39(rs.getString("t39"));
				member.setT40(rs.getString("t40"));
				member.setT41(rs.getString("t41"));
				member.setT42(rs.getString("t42"));
				member.setT43(rs.getString("t43"));
				member.setT44(rs.getString("t44"));
				member.setT45(rs.getString("t45"));
				member.setT46(rs.getString("t46"));
				member.setT47(rs.getString("t47"));
				member.setT48(rs.getString("t48"));
				member.setT49(rs.getString("t49"));
				member.setT50(rs.getString("t50"));
				member.setT51(rs.getString("t51"));
				member.setT52(rs.getString("t52"));
				member.setT53(rs.getString("t53"));
				member.setT54(rs.getString("t54"));
				member.setT55(rs.getString("t55"));
				member.setT56(rs.getString("t56"));
				member.setT57(rs.getString("t57"));
				member.setT58(rs.getString("t58"));
				member.setT59(rs.getString("t59"));
				member.setT60(rs.getString("t60"));
				member.setT61(rs.getString("t61"));
				member.setT62(rs.getString("t62"));
				member.setT63(rs.getString("t63"));
				member.setT64(rs.getString("t64"));
				member.setT65(rs.getString("t65"));
				member.setT66(rs.getString("t66"));
				member.setT67(rs.getString("t67"));
				member.setT68(rs.getString("t68"));
				member.setT69(rs.getString("t69"));
				member.setT70(rs.getString("t70"));
				member.setT71(rs.getString("t71"));
				member.setT72(rs.getString("t72"));
				member.setT73(rs.getString("t73"));
				member.setT74(rs.getString("t74"));
				member.setT75(rs.getString("t75"));
			}
		} catch(SQLException e) {
			throw e;
		} finally {		
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			disconnectDB();
		}
		return member;
	}

}