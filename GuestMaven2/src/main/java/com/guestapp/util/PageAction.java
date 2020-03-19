package com.guestapp.util;

import org.springframework.stereotype.Component;

@Component
public class PageAction {

	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		String file = "javascript:getData(";
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); // ������ ��
		int pageBlock = 3;
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		StringBuilder sb = new StringBuilder();
		// ����
		if (startPage > pageBlock) { // getData(2,'name','ȫ�浿')
			sb.append("<a href=");
			sb.append(file);
			sb.append((startPage - pageBlock));
			sb.append(",'" + field + "'");
			sb.append(",'" + word + "')");
			sb.append(">����</a>");
		}
		// ������ ���
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) { // ����������
				sb.append("[" + i + "]");
			} else {
				sb.append("<a href=");
				sb.append(file);
				sb.append(i);
				sb.append(",'" + field + "'");
				sb.append(",'" + word + "')");
				sb.append(">" + i + "</a>");
			}
		}

		// ����
		if (endPage < pageCount) {
			sb.append("<a href=");
			sb.append(file);
			sb.append((startPage + pageBlock));
			sb.append(",'" + field + "'");
			sb.append(",'" + word + "')");
			sb.append(">����</a>");
		}

		return sb.toString();
	}

}
