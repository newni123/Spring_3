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

	public int qnaReply(QnaVO qnaVO) throws Exception {
		// 부모의 정보를 알아오기(hidden으로 받아온 부모의 num으로 ref,step,depth 가공)
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum()); // qnaVO에 덮어 씌우면 답글의 내용이 부모의 내용으로 씌워짐
		qnaVO.setRef(parent.getRef()); // 부모의 ref값을 자식의 ref 값에 넣어줌
		qnaVO.setStep(parent.getStep() + 1);
		qnaVO.setDepth(parent.getDepth() + 1);
		return qnaDAO.qnaReply(qnaVO);
	}

	public int qnaDelete(int num) throws Exception {
		return qnaDAO.qnaDelete(num);
	}

	public QnaVO qnaSelect(int num) throws Exception {
		return qnaDAO.qnaSelect(num);
	}

	public int qnaWrite(QnaVO qnaVO) throws Exception {
		return qnaDAO.qnaWrite(qnaVO);
	}

	public List<QnaVO> qnaList(Pager pager) throws Exception {
		// DB rownum 계산
		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(pager);
	}
}
