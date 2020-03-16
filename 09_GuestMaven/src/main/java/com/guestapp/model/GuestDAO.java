package com.guestapp.model;

import java.util.HashMap;
import java.util.List;

import com.guestapp.vo.GuestVO;

public interface GuestDAO {
	// �߰�
	// ����
	// ����
	// ��ü����(�˻�����)
	// �󼼺���
	public void dao_insert(String mid, GuestVO guest);
	public void dao_update(String mid, GuestVO guest);
	public void dao_delete(String mid, int num);
	public List<GuestVO> dao_list(String mid, HashMap<String, String> hm);
	public GuestVO dao_findById(String mid, int num);
}
