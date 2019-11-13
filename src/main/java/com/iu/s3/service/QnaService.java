package com.iu.s3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.RowMaker;

@Service
public class QnaService {
	@Inject
	private QnaDAO qnaDAO;

	public int qnaDelete(int num) throws Exception{
		return qnaDAO.qnaDelete(num);
	}
	
	public QnaVO qnaSelect(int num) throws Exception{
		return qnaDAO.qnaSelect(num);
	}
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		// DB rownum 계산
		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(pager);
	}
}
