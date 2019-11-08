package com.iu.s3;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.service.board.NoticeService;

@Controller
public class NoticeController {
	@Inject
	private NoticeService noticeService;

	@RequestMapping(value = "notice/noticeWrite", method = RequestMethod.POST)
	public void noticeWrite2(NoticeVO noticeVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = "작성 실패";
		if (noticeService.noticeWrite(noticeVO) > 0) 
			msg = "작성 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./noticeList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "notice/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "notice/noticeWrite";
	}

	@RequestMapping(value = "notice/noticeUpdate", method = RequestMethod.POST)
	public void noticeUpdate2(NoticeVO noticeVO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "수정 실패";
		if (noticeService.noticeUpdate(noticeVO) > 0) 
			msg = "수정 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./noticeList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "notice/noticeUpdate", method = RequestMethod.GET)
	public NoticeVO noticeUpdate(int num) throws Exception {
		return noticeService.noticeSelect(num);
	}

	@RequestMapping("notice/noticeDelete")
	public void noticeDelete(int num,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "삭제 실패";
		if (noticeService.noticeDelete(num) > 0) 
			msg = "삭제 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./noticeList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}

	@RequestMapping("notice/noticeSelect")
	public NoticeVO noticeSelect(int num) throws Exception {
		return noticeService.noticeSelect(num);
	}

	// list : /notice/noticeList GET
	@RequestMapping("notice/noticeList")
	public List<NoticeVO> noticeList(Model model) throws Exception {
		List<NoticeVO> noticeVOs = noticeService.noticeList();
		model.addAttribute("list", noticeVOs);
		return noticeVOs;
	}
	// view : /WEB-INF/views/notice/noticeList.jsp

}
