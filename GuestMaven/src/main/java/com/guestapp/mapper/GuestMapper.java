package com.guestapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.guestapp.vo.GuestVO;

public interface GuestMapper {
	@Insert("insert into guestbook "
			+"values (guestbook_seq.nextval,#{name},"
			+"#{content},#{grade},sysdate,#{ipaddr})"
			)
	public void insert(GuestVO guest);
	
	@Select("select * from guestbook order by num desc")
	public List<GuestVO> list();
	
	@Update("update guestbook set "
			+"content=#{content}, grade=#{grade} "
			+"where num=#{num}"
			)
	public void update(GuestVO guest);
	
	@Delete("delete from guestbook "
			+ "where num=#{num}")
	public void delete(int num);
	
	@Select("select * from guestbook "
			+ "where num=#{num}")
	public GuestVO view(int num);
}
