package cn.jbit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;

public interface Service {

	/**
	 * 分页查询
	 * 查询所有帖子/模糊查询
	 * @return
	 */
	public List<Invitation> selInvitation(
			@Param("title")String title,
			@Param("currentPageNo") int currentPageNo,
			@Param("pageSize") int pageSize
			);
	
	/**
	 * 根据帖子id查询帖子回复
	 * @param id
	 * @return
	 */
	public List<Reply_detail> selReply_detail(@Param("id")int id);
	
	/**
	 * 根据帖子id 添加回复
	 * @param reply_detail
	 * @return
	 */
	public int addReply_detail(Reply_detail reply_detail);
	
	/**
	 * 删除功能
	 */
	public void del(int id);
	
	/**
	 * 查询记录数
	 * @param title
	 * @return
	 */
	public int count(@Param("title")String title);
}
