package cn.jbit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;

public interface Mapper {

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
	 * 根据帖子id 删除帖子
	 * @return
	 */
	public int delInvitation(@Param("id")int id );
	
	/**
	 * 根据帖子id 删除帖子回复
	 * @return
	 */
	public int delReply_detail(@Param("id")int id );
	
	/**
	 * 查询记录数
	 * @param title
	 * @return
	 */
	public int count(@Param("title")String title);
}
