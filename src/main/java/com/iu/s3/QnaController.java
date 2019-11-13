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
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.QnaService;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("qna/**")
public class QnaController {
	@Inject
	private QnaService qnaService;

	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public void qnaReply(QnaVO qnaVO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = qnaService.qnaReply(qnaVO);
		String msg = "답글 작성 실패";
		if (result > 0)
			msg = "답글 작성 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./qnaList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
		
	}

	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public void qndReply(int num, Model model) throws Exception {
		model.addAttribute("num", num);
	}

	@RequestMapping(value = "qnaDelete")
	public void qnaDelete(int num, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "삭제 실패";
		if (qnaService.qnaDelete(num) > 0)
			msg = "삭제 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./qnaList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "qnaSelect")
	public QnaVO qnaSelect(int num) throws Exception {
		return qnaService.qnaSelect(num);
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public void qnaWrite2(QnaVO qnaVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "작성 실패";
		if (qnaService.qnaWrite(qnaVO) > 0)
			msg = "작성 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./qnaList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public void qnaWrite() throws Exception {
	}

	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(/* Model model, */Pager pager) throws Exception {
		List<QnaVO> qnaVOs = qnaService.qnaList(pager);
		ModelAndView mv = new ModelAndView();
		/*
		 * model.addAttribute("list",qnaVOs); model.addAttribute("pager",pager);
		 */
		mv.addObject("list", qnaVOs);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		return mv;
	}

}
