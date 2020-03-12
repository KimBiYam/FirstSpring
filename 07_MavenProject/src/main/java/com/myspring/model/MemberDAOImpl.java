package com.myspring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private JdbcTemplate template;

	@Override
	public void dao_insert(MemberVO member) {
		// TODO Auto-generated method stub
		String sql = "insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param = new Object[] { member.getId(), member.getPass(), member.getName(), member.getAddr(),
				member.getMemo() };
		template.update(sql, param);
	}

	@Override
	public List<MemberVO> dao_list() {
		// TODO Auto-generated method stub
		String sql = "select * from springmember order by id";
		List<MemberVO> list = template.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberVO member = new MemberVO();
				member.setAddr(rs.getString("addr"));
				member.setId(rs.getString("id"));
				member.setMemo(rs.getString("memo"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});

		return list;
	}

	@Override
	public MemberVO dao_view(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from springmember where id='"+id+"'";
		MemberVO user = (MemberVO) template.queryForObject(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberVO member = new MemberVO();
				member.setAddr(rs.getString("addr"));
				member.setId(rs.getString("id"));
				member.setMemo(rs.getString("memo"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		return user;
	}

	@Override
	public void dao_update(MemberVO member) {
		// TODO Auto-generated method stub
		String sql = "update springmember set pass=?,name=?,addr=?,memo=? where id=?";
		Object[] param = new Object[] {
				member.getPass(),member.getName(),member.getAddr(),member.getMemo(),member.getId()
		};
		template.update(sql, param);
	}

	@Override
	public void dao_delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from springmember where id='"+id+"'";
		template.update(sql);
	}

}
