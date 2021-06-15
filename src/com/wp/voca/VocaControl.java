package com.wp.voca;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.wp.voca.VocaDO;
import com.wp.voca.VocaDao;
import com.wp.voca.VocaDbcpDao;
import com.wp.voca.VocamemberDO;
import com.wp.voca.VocamemberDao;
import com.wp.voca.VocamemberDbcpDao;
/**
 * Servlet implementation class MemberControl
 */
@WebServlet("/voca/*")
public class VocaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VocaControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		VocaDao dao = (VocaDao)session.getAttribute("dao");
		VocamemberDao dao1 = (VocamemberDao)session.getAttribute("dao1");
		VocamemberDO vocamember = new VocamemberDO();
		String ID = (String)request.getParameter("id");
	    String pass = (String)request.getParameter("passwd");
	    String NAME = (String)request.getParameter("name");
	    int totall = vocamember.getTotal();
	    int total2 = vocamember.getTotal2();
	    int total3 = vocamember.getTotal3();
	    session.setAttribute("sid", ID);
	    String sql="SELECT * FROM Vocamember where id='"+ID+"'";
		Connection conn = null;
		if (dao1 == null) {
			ServletContext context = getServletContext();
			dao1 = new VocamemberDbcpDao(
				context.getInitParameter("dbcp_resource_name")
			);
			session.setAttribute("dao1", dao1);
		}
		if (dao == null) {
			ServletContext context = getServletContext();
			dao = new VocaDbcpDao(
				context.getInitParameter("dbcp_resource_name")
			);
			session.setAttribute("dao", dao);
		}
		// step #2. data processing
		String pathInfo = request.getPathInfo();
		String action = request.getParameter("action");
		String viewName = null;
		List<VocaDO> memberList = null;
		List<VocamemberDO> vocamemberList = null;
		if (action.equals("register_form")) {
			viewName = "/voca/joinform.jsp";
		}
		if (action.equals("register")) {
			vocamember.setId(request.getParameter("id"));
			vocamember.setPasswd(request.getParameter("passwd"));
			vocamember.setName(request.getParameter("name"));
			try {
				dao1.insertVocamember(vocamember);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}

			viewName = "redirect:/loginform.jsp";
		}
		if (action.equals("joinform")) {
			// get all records from db table
			try {
				memberList = dao.getVocaList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			request.setAttribute("member_list", memberList);
			viewName = "/joinform.jsp";			
		}
		if(action.equals("join")) {
			try {
				Context init = new InitialContext();
		        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle_xe");
		        conn = ds.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.executeUpdate();
		        ResultSet rs = pstmt.executeQuery();
		        String id = request.getParameter("id");
		        session.setAttribute("id", id);
		        vocamember.setId(request.getParameter(id));
		        if(rs.next()){
		          if(ID.equals(rs.getString(1))==true && pass.equals(rs.getString(2))==true){
		        	 rs.close();
		        	 viewName = "/main.jsp";
		          }
		          else if(pass.equals(rs.getString(2))==false){
		              rs.close();
		              viewName = "/loginform.jsp";
		          }
		        }
		        else{
		            rs.close();
		            viewName = "/loginform.jsp";
		        }
		    }catch(Exception e){
		        e.printStackTrace();
		    }
			finally{
				try{
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (action.equals("member_list")) {
			// get all records from db table
			memberList = null;

			try {
				session.setAttribute("cut", "1");
				memberList = dao.getVocaList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			// bind goods into to request attribute
			request.setAttribute("member_list", memberList);
			viewName = "/test1.jsp";			
		}
		if (action.equals("test1")) {
			// get all records from db table
			memberList = null;
			int total=0;
			String cut = request.getParameter("cut");
			request.setCharacterEncoding("UTF-8");
			if(cut.equals("2")) { 
				session.setAttribute("cut", (String)"2");
				vocamember.setA1(Integer.parseInt(request.getParameter("q1")));
				vocamember.setA2(Integer.parseInt(request.getParameter("q2")));
				vocamember.setA3(Integer.parseInt(request.getParameter("q3")));
			}
			if(cut.equals("3")) { 
				session.setAttribute("cut", (String)"3");
				vocamember.setA4(Integer.parseInt(request.getParameter("q4")));
				vocamember.setA5(Integer.parseInt(request.getParameter("q5")));
				vocamember.setA6(Integer.parseInt(request.getParameter("q6")));
			}
			if(cut.equals("4")) { 
				session.setAttribute("cut", (String)"4");
				vocamember.setA7(Integer.parseInt(request.getParameter("q7")));
				vocamember.setA8(Integer.parseInt(request.getParameter("q8")));
				vocamember.setA9(Integer.parseInt(request.getParameter("q9")));
			}
			if(cut.equals("5")) { 
				session.setAttribute("cut", (String)"5");
				vocamember.setA10(Integer.parseInt(request.getParameter("q10")));
				vocamember.setA11(Integer.parseInt(request.getParameter("q11")));
				vocamember.setA12(Integer.parseInt(request.getParameter("q12")));
			}
			try {
				memberList = dao.getVocaList();
				dao1.updateVocamember(vocamember);
				if(cut.equals("6")) {
					vocamember.setA13(Integer.parseInt(request.getParameter("q13")));
					vocamember.setA14(Integer.parseInt(request.getParameter("q14")));
					vocamember.setA15(Integer.parseInt(request.getParameter("q15")));
					dao1.updateVocamember(vocamember);
					total = vocamember.getA1()+vocamember.getA2()+vocamember.getA3()+vocamember.getA4()+vocamember.getA5()+vocamember.getA6()+vocamember.getA7()+vocamember.getA8()+vocamember.getA9()+vocamember.getA10()+vocamember.getA11()+vocamember.getA12()+vocamember.getA13()+vocamember.getA14()+vocamember.getA15();
					total2 = vocamember.getA1()+vocamember.getA2()+vocamember.getA3()+vocamember.getA4()+vocamember.getA5()+vocamember.getA6()+vocamember.getA7()+vocamember.getA8()+vocamember.getA9()+vocamember.getA10()+vocamember.getA11()+vocamember.getA12()+vocamember.getA13()+vocamember.getA14()+vocamember.getA15();
					total3 = vocamember.getA1()+vocamember.getA2()+vocamember.getA3()+vocamember.getA4()+vocamember.getA5()+vocamember.getA6()+vocamember.getA7()+vocamember.getA8()+vocamember.getA9()+vocamember.getA10()+vocamember.getA11()+vocamember.getA12()+vocamember.getA13()+vocamember.getA14()+vocamember.getA15();
					vocamember.setTotal(total);
					vocamember.setTotal2(total2);
					vocamember.setTotal3(total3);
					viewName = "/main.jsp";	
					RequestDispatcher view = request.getRequestDispatcher(viewName);
					view.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			// bind goods into to request attribute
			request.setAttribute("member_list", memberList);
			viewName = "/test1.jsp";		
		}
		if (action.equals("member_info")) {
			// get all records from db table
			String id = request.getParameter("id");
			memberList = null;
			try {
				memberList = dao.getVocaList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			// bind goods into to request attribute
			request.setAttribute("member_list", memberList);
			viewName = "/member_info.jsp";			
		}
		if (action.equals("delete")) {
				// get code parameter
				String id = request.getParameter("id");
				// data processing...
				try {
					dao1.deleteVocamember(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
				// redirect to goods-list page
				viewName = "redirect:/voca?action=member_list";
		}
		if (action.equals("update_form")) {
			// get code parameter
			String id = request.getParameter("id");
			//search goods info of the code
			VocaDO member = null;
			try {
				member = dao.getMember(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			// bind goods into to request attribute
			request.setAttribute("member", member);
			viewName = "/member_info.jsp";				
		}

		// step #3. output results
		if (viewName != null) {
			if (viewName.contains("redirect:")) {
				String location = viewName.split(":")[1];
				response.sendRedirect(request.getContextPath() + location);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		}
}	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
