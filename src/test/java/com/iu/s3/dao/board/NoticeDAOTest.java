package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase {

	@Inject
	private NoticeDAO noticeDAO;

	// @Test
	public void checkDAO() throws Exception {
		assertNotNull(noticeDAO);
	}
	@Test
	public void noticeCountTest() throws Exception{
		int result = noticeDAO.noticeCount();
		assertEquals(218, result);
	}
	//@Test
	public void noticeWriteTest() throws Exception {
		for (int i = 1; i < 119; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("nt" + i);
			noticeVO.setWriter("nw" + i);
			noticeVO.setContents("nc" + i);
			int result = noticeDAO.noticeWrite(noticeVO);
		}
		// assertEquals(1, result);
	}

	// @Test
	public void noticeDeleteTest() throws Exception {
		int result = noticeDAO.noticeDelete(3);
		assertEquals(1, result);
	}

	// @Test
	public void noticeUpdate() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("t1");
		noticeVO.setWriter("w2");
		noticeVO.setContents("c3");
		noticeVO.setNum(2);
		int result = noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}

	// @Test
	public void noticeSelect() throws Exception {
		NoticeVO noticeVO = noticeDAO.noticeSelect(2);
		assertNotNull(noticeVO);
	}

	// @Test
	public void noticeList() throws Exception {
	//	List<NoticeVO> noticeVOs = noticeDAO.noticeList();
		//assertNotEquals(0, noticeVOs);
	}
}
