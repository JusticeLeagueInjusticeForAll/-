package cn.jbit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;

public interface Service {

	/**
	 * ��ҳ��ѯ
	 * ��ѯ��������/ģ����ѯ
	 * @return
	 */
	public List<Invitation> selInvitation(
			@Param("title")String title,
			@Param("currentPageNo") int currentPageNo,
			@Param("pageSize") int pageSize
			);
	
	/**
	 * ��������id��ѯ���ӻظ�
	 * @param id
	 * @return
	 */
	public List<Reply_detail> selReply_detail(@Param("id")int id);
	
	/**
	 * ��������id ��ӻظ�
	 * @param reply_detail
	 * @return
	 */
	public int addReply_detail(Reply_detail reply_detail);
	
	/**
	 * ɾ������
	 */
	public void del(int id);
	
	/**
	 * ��ѯ��¼��
	 * @param title
	 * @return
	 */
	public int count(@Param("title")String title);
}
