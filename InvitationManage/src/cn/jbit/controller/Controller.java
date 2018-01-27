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
		//客户传给我们的值 int类型自定 默认进来传递1
		int _pageIndex=1;
		if(null!=pageIndex&&""!=pageIndex){
			//页面传来的pageIndex 不为空就给_pageIndex值 页面去第几页
			_pageIndex=Integer.valueOf(pageIndex);
		}
		//设置页面的大小 多少条数据
		int pageSize =2;
		
		//设置总记录数
		int count=service.count(title);
		
		//new 一个分页对象 给里面的属性赋值
		PageSupport page=new PageSupport();
		//指定第几页
		page.setCurrentPageNo(_pageIndex);
		//页面大小 一页多少条数据
		page.setPageSize(pageSize);
		//总记录数
		page.setTotalCount(count);
		
		//给上面3个属性赋值了 才得出总页数 如果没给 是算不出总页数的 所有上面3个是必须的
		int totalPageCount = page.getTotalPageCount();
		
		// 控制首页和尾页
		if (_pageIndex < 1) {
			_pageIndex = 1;
		} else if (_pageIndex > totalPageCount) {
			_pageIndex = totalPageCount;
		}
		//判断完 不能小于1 不能大于总页数 重新再往对象里赋值 page这个对象就是我们需要的数据了
		page.setCurrentPageNo(_pageIndex);
		//将这个页面对象保存到session里
		session.setAttribute("page", page);
		
		//这时候就可以查询集合了
		List<Invitation> list=service.selInvitation(title, _pageIndex, pageSize);
		//将对象保存到session里
		session.setAttribute("list", list);
		//将title条件页存放到session
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
