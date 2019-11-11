package com.iu.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.util.RowMaker;

@Repository
public class NoticeDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";
	// final이 오니까 대문자로 선언, 값은 noticeMapper에 지정한 대로 + .
	public int noticeCount() throws Exception{
		return sqlSession.selectOne(NAMESPACE + "noticeCount");
	}
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		return sqlSession.update(NAMESPACE + "noticeUpdate",noticeVO);
	}
	public List<NoticeVO> noticeList(RowMaker rowMaker) throws Exception{
		return sqlSession.selectList(NAMESPACE+"noticeList",rowMaker);
	}
	public NoticeVO noticeSelect(int num) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE + "noticeSelect", map);
	}

	public int noticeDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE + "noticeDelete", num);
	}

	public int noticeWrite(NoticeVO noticeVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "noticeWrite", noticeVO); // 결과 값 어차피 숫자오니까 그냥 바로 리턴
	}
}
