package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance;

	public static MemberDAOImpl getInstance() {
		if (instance == null) {
			instance = new MemberDAOImpl();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	@Override
	public ArrayList<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> userlist = new ArrayList<>();
		try {
			String sql = "select * from springmember";
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				MemberDTO user = new MemberDTO();
				user.setAddr(rs.getString("addr"));
				user.setId(rs.getString("id"));
				user.setMemo(rs.getString("memo"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setReg_date(rs.getString("reg_date"));
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, rs, st, null);
		}
		return userlist;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemberDTO user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
			con=getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddr());
			ps.setString(5, user.getMemo());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con, null, null, ps);
		}

	}

	@Override
	public void update(MemberDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void closeConnection(Connection con, ResultSet rs, Statement st, PreparedStatement ps) {
		try {
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
