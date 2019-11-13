package com.iu.s3.dao.Test;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.QnaService;
import com.iu.s3.util.Pager;

public class QnaServiceTest extends TestAbstractCase {

	@Inject
	private QnaService qnaService;
	
	//@Test
	public void qnaListtest() throws Exception {
		Pager pager = new Pager(); // 만들고 아무것도 넣지 않으면 null 이기 때문에 default로 넣은 curPage = 1,perPage = 10이 나와야함
		pager.makePage(50); // 글이 50개 있다고 가정할때
		List<QnaVO> qnaVOs = qnaService.qnaList(pager);
		//assertNotEquals(0, qnaVOs.size());
		assertEquals(1,(int)pager.getStartRow());
		assertEquals(1,(int)pager.getLastRow());
		assertEquals(1,(int)pager.getStartNum());
		assertEquals(5,(int)pager.getLastNum());
	}
	//@Test
	public void qnaReplyUpdate(QnaVO qnaVO) throws Exception{
		qnaVO.setTitle("t1");
		qnaVO.setWriter("w1");
		qnaVO.setContents("c1");
		
		assertEquals(1, qnaService.qnaReply(qnaVO));
		
	}

}
