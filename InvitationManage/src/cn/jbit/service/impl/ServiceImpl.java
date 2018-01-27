package cn.jbit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.jbit.dao.Mapper;
import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;
import cn.jbit.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Resource
	private Mapper mapper;
	
	@Override
	public List<Invitation> selInvitation(String title, int currentPageNo,
			int pageSize) {
		List<Invitation> list = null;
		try {
			currentPageNo=(currentPageNo-1)*pageSize;
			
			list = mapper.selInvitation(title, currentPageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}

	@Override
	public List<Reply_detail> selReply_detail(int id) {
		// TODO Auto-generated method stub
		return mapper.selReply_detail(id);
	}

	@Override
	public int addReply_detail(Reply_detail reply_detail) {
		// TODO Auto-generated method stub
		return mapper.addReply_detail(reply_detail);
	}

	

	@Override
	public int count(String title) {
		// TODO Auto-generated method stub
		return mapper.count(title);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		mapper.delReply_detail(id);
		mapper.delInvitation(id);
	}


}
