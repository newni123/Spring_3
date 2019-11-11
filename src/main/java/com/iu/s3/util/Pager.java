package com.iu.s3.util;

public class Pager {
	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager() {
		perPage = 10; // 한 블럭당 글이 10개씩 표기 
	}

	public Integer getCurPage() {
		if(this.curPage == null)
			this.curPage = 1;
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public void makePager(int totalCount) {
		int totalPage = totalCount/ perPage;
		if (totalCount % perPage != 0)
			totalPage++;
		int perBlock = 5; // 한번에 보여지는 블럭 수
		totalBlock = totalPage / perBlock ; // 전체 블럭의 수
		if(totalPage % perBlock != 0)
			totalBlock++;
		curBlock = curPage / perBlock; // 현재 몇번째 블럭인지
		if(curPage % perBlock != 0)
			curBlock++;
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		if(curBlock == totalBlock) // 현재 마지막 블럭일 경우
			lastNum = totalPage; // 블럭의 마지막 숫자는 총 페이지의 수
	}
	public RowMaker makeRow() {
		int startRow = (this.getCurPage() - 1) * perPage + 1;
		int lastRow = this.getCurPage() * perPage;
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		return rowMaker;
	}
	
}
