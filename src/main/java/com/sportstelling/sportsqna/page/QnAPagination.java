package com.sportstelling.sportsqna.page;

public class QnAPagination {
	//한 페이지당 게시글 수
	private int pageSize = 20;
	//한 블럭당 페이지 수
	private int rangeSize = 10;
	private int currentPage = 1;
	private int currentRange = 1;
	//총 게시글 수
	private int listCount;
	//총 페이지 수
	private int pageCount;
	//총 블럭수
	private int rangeCount;
	private int startPage = 1;
	private int endPage = 1;
	private int startIndex = 0;
	private int previousPage;
	private int nextPage;
	//getter, setter
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentRange() {
		return currentRange;
	}
	public void setCurrentRange(int currentPage) {
		this.currentRange = (int)((currentPage - 1) / rangeSize) + 1;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int listCount) {
		this.pageCount = (int)Math.ceil(listCount * 1.0 / pageSize); 
	}
	public int getRangeCount() {
		return rangeCount;
	}
	public void setRangeCount(int pageCount) {
		this.rangeCount = (int)Math.ceil(pageCount * 1.0 / rangeSize);
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
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int currentPage) {
		this.startIndex = (currentPage - 1) * pageSize;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	public QnAPagination(int listCount, int currentPage) {
		setCurrentPage(currentPage);
		setListCount(listCount);
		
		setPageCount(listCount);
		setRangeCount(this.pageCount);
		rangeSetting(currentPage);
		
		//DB 질의를 위한 startIndex 설정
		setStartIndex(currentPage);
	}
	public void rangeSetting(int currentPage) {
		setCurrentRange(currentPage);
		this.startPage = (currentRange - 1) * rangeSize + 1;
		this.endPage = startPage + rangeSize - 1;
		
		if(this.endPage > this.pageCount) {
			this.endPage = pageCount;
		}
		
		this.previousPage = currentPage - 1;
		this.nextPage = currentPage + 1;
	}
}
