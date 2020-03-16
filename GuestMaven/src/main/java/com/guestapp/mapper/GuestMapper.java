package com.guestapp.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.guestapp.vo.GuestVO;

public interface GuestMapper {
	@Insert("insert into guestbook "
			+"values (guestbook_seq.nextval,#{name},"
			+"#{content},#{grade},sysdate,#{ipaddr})"
			)
	public void insert(GuestVO guest);
	
	public List<GuestVO> list(HashMap<String, String> hm);
	
	public void update(GuestVO guest);
	
	public void delete(int num);
	
	public GuestVO view(int num);
}