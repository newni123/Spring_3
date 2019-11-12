package com.iu.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.NoticeDAO;
import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.RowMaker;

@Service
public class NoticeService {
	@Inject
	private NoticeDAO noticeDAO;

	public List<NoticeVO> noticeList(Pager pager) throws Exception {
		//System.out.println(pager.getKind());
		//System.out.println(pager.getSearch());
		pager.makeRow();
		pager.makePager(noticeDAO.noticeCount(pager));
		return noticeDAO.noticeList(pager);
	}

	public NoticeVO noticeSelect(int num) throws Exception {
		return noticeDAO.noticeSelect(num);
	}

	public int noticeUpdate(NoticeVO noticeVO) throws Exception {
		return noticeDAO.noticeUpdate(noticeVO);
	}

	public int noticeDelete(int num) throws Exception {
		return noticeDAO.noticeDelete(num);
	}

	public int noticeWrite(NoticeVO noticeVO) throws Exception {
		return noticeDAO.noticeWrite(noticeVO);
	}
}
