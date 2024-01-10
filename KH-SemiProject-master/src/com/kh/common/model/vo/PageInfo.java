package com.kh.common.model.vo;

public class PageInfo {

	// 7가지 변수들을 필드로 정의
	private int listCount; // 현재 일반게시판의 게시글 총 갯수 => BOARD 로부터 조회 COUNT(*) 활용 (STATUS = 'Y')
	private int currentPage; // 현재 페이지 (즉, 사용자가 요청한 페이지) request.getParameter("currentPage");
	private int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수 => 10개로 고정
	private int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수 => 10개로 고정
	private int maxPage; // 가장 마지막 페이지가 몇번 페이지인지 (== 총 페이지의 갯수)
	private int startPage; // 페이지 하단에 보여질 페이징바의 시작수
	private int endPage;
	
	public PageInfo() {
		super();
	}

	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
}
