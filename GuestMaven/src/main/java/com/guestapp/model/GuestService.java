package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import com.guestapp.vo.GuestVO;

public interface GuestService {
	// �߰�
	// ����
	// ����
	// ��ü����(�˻�����)
	// �󼼺���
	public void insert(GuestVO guest);
	public void update(GuestVO guest);
	public void delete(int num);
	public List<GuestVO> list(HashMap<String, Object> hm);
	public GuestVO findById(int num);
}
