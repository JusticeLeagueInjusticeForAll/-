package cn.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;

public interface Mapper {

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
	 * ��������id ɾ������
	 * @return
	 */
	public int delInvitation(@Param("id")int id );
	
	/**
	 * ��������id ɾ�����ӻظ�
	 * @return
	 */
	public int delReply_detail(@Param("id")int id );
	
	/**
	 * ��ѯ��¼��
	 * @param title
	 * @return
	 */
	public int count(@Param("title")String title);
}
