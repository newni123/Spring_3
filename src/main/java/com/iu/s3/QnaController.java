package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

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
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(/*Model model,*/Pager pager) throws Exception{
		List<QnaVO> qnaVOs = qnaService.qnaList(pager);
		ModelAndView mv = new ModelAndView();
		/*model.addAttribute("list",qnaVOs);
		model.addAttribute("pager",pager);*/
		mv.addObject("list",qnaVOs);
		mv.addObject("pager",pager);
		mv.setViewName("qna/qnaList");
		return mv;
	}
	
}
