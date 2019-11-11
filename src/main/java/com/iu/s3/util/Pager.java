package com.iu.s3.util;

public class Pager {
	private Integer curPage; // 현재 목록의 페이지 번호
	private Integer perPage; // 한 페이지당 보여질 글 개수
	private Integer startNum; // 현재 블럭에서 시작번호 (ex: 1,6,11..)
	private Integer lastNum;  // 현재 블럭에서 마지막 번호(ex:5,10,15..)
	private Integer curBlock; // 현재 블럭이 몇번째 블럭인지 (ex: 12345(1),678910(2)) 괄호안의 숫자
	private Integer totalBlock; // 블럭의 총 개수

	public Pager() {
		perPage = 10;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurPage() {
		if (this.curPage == null) {
			this.curPage = 1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void makePager(int totalCount) {
		// 1. 전체 글의 개수

		// 2. 전체 페이지의 개수
		int totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage++;
		}

		// 3. 전체 블럭의 개수
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 4. curPage를 이용해서 curBlock 구하기
		curBlock = curPage / perBlock;
		if (curPage % perBlock != 0) {
			curBlock++;
		}

		// 5. curBlock으로 startNum, lastNum 구하기
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}

	public RowMaker makeRow() {
		// rownum 계산
		int startRow = (this.getCurPage() - 1) * perPage + 1;
		int lastRow = this.getCurPage() * perPage;
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		return rowMaker;
	}

}
