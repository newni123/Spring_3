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
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		RowMaker rowMaker = pager.makeRow();
		pager.makePager(qnaDAO.qnaCount());
		return qnaDAO.qnaList(rowMaker);
	}
}
