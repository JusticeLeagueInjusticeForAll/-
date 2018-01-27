package cn.jbit.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tools.PageSupport;

import cn.jbit.pojo.Invitation;
import cn.jbit.pojo.Reply_detail;
import cn.jbit.service.Service;

@org.springframework.stereotype.Controller
public class Controller {

	@Resource
	private Service service;
	
	@RequestMapping(value = "list")
	public String list(HttpSession session,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "pageIndex", required = false) String pageIndex
			){
		//�ͻ��������ǵ�ֵ int�����Զ� Ĭ�Ͻ�������1
		int _pageIndex=1;
		if(null!=pageIndex&&""!=pageIndex){
			//ҳ�洫����pageIndex ��Ϊ�վ͸�_pageIndexֵ ҳ��ȥ�ڼ�ҳ
			_pageIndex=Integer.valueOf(pageIndex);
		}
		//����ҳ��Ĵ�С ����������
		int pageSize =2;
		
		//�����ܼ�¼��
		int count=service.count(title);
		
		//new һ����ҳ���� ����������Ը�ֵ
		PageSupport page=new PageSupport();
		//ָ���ڼ�ҳ
		page.setCurrentPageNo(_pageIndex);
		//ҳ���С һҳ����������
		page.setPageSize(pageSize);
		//�ܼ�¼��
		page.setTotalCount(count);
		
		//������3�����Ը�ֵ�� �ŵó���ҳ�� ���û�� ���㲻����ҳ���� ��������3���Ǳ����
		int totalPageCount = page.getTotalPageCount();
		
		// ������ҳ��βҳ
		if (_pageIndex < 1) {
			_pageIndex = 1;
		} else if (_pageIndex > totalPageCount) {
			_pageIndex = totalPageCount;
		}
		//�ж��� ����С��1 ���ܴ�����ҳ�� �������������︳ֵ page����������������Ҫ��������
		page.setCurrentPageNo(_pageIndex);
		//�����ҳ����󱣴浽session��
		session.setAttribute("page", page);
		
		//��ʱ��Ϳ��Բ�ѯ������
		List<Invitation> list=service.selInvitation(title, _pageIndex, pageSize);
		//�����󱣴浽session��
		session.setAttribute("list", list);
		//��title����ҳ��ŵ�session
		session.setAttribute("title", title);
		return "list";
	}
	
	@RequestMapping(value = "byId")
	public String byId(@RequestParam("id") String id,HttpSession session){
		int _id=Integer.valueOf(id);
		List<Reply_detail> list=service.selReply_detail(_id);
		session.setAttribute("reply", list);
		session.setAttribute("invId", id);
		return "byId";
	}
	@RequestMapping(value = "getAdd")
	public String getAdd(){
		return "add";
	}
	@ResponseBody
	@RequestMapping(value = "add")
	public int add(@ModelAttribute("reply_detail") Reply_detail reply_detail,
			HttpSession session){
		String invId=(String)session.getAttribute("invId");
		int id=Integer.valueOf(invId);
		reply_detail.setInvid(id);
		reply_detail.setCreatedate(new Date());
		int i=service.addReply_detail(reply_detail);
		return i;
	}
	@ResponseBody
	@RequestMapping(value = "nnn")
	public int nnn(){
		System.out.println(111);
		return 1;
	}
/*	@RequestMapping(value = "add")
	public String add(@ModelAttribute("reply_detail") Reply_detail reply_detail,
			HttpSession session){
		List<Reply_detail> invId=(List<Reply_detail>)session.getAttribute("reply");
		reply_detail.setInvid(invId.get(0).getInvid());
		reply_detail.setCreatedate(new Date());
		service.addReply_detail(reply_detail);
		return "redirect:/byId?id="+invId.get(0).getInvid();
	}*/
	
	@RequestMapping(value = "del")
	public String del(@RequestParam("id") String id,HttpSession session){
		try{
		int _id=Integer.valueOf(id);
		service.del(_id);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		session.setAttribute("msg", "true");
		return "index";
	}
}
