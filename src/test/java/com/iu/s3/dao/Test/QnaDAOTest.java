package com.iu.s3.dao.Test;


import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;

public class QnaDAOTest extends TestAbstractCase {
	@Inject
	private QnaDAO qnaDAO; 
	@Test
	public void insertTest() throws Exception {
		for (int i = 0; i < 120; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("QnATitle" + i);
			qnaVO.setWriter("QnAWriter" + i);
			qnaVO.setContents("QnAContents" + i);
			int result = qnaDAO.qnaWrite(qnaVO);
		}
	}
	
}
