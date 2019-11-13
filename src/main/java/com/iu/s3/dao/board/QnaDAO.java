package com.iu.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;

@Repository
public class QnaDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception{
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate",qnaVO);
	}
	public int qnaReply(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaReply",qnaVO);
	}
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"qnaList",pager);
	}
	public int qnaCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount",pager);
	}
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaWrite",qnaVO);
	}
	public QnaVO qnaSelect(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaSelect",num);
	}
	public int qnaDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"qnaDelete",num);
	}
}
