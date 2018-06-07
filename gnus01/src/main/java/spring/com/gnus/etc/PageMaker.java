package spring.com.gnus.etc;

public class PageMaker {
	
	private int totalCount;			// 전체 게시물 수
	private int countList;			// 리스트 수
	private int pageNum;			// 페이지 번호
	private int contentNum = 10;	// 한 페이지에 보일 갯수
	private int startPage = 1;		// beginPage default 1
	private int endPage = 5;		// endPage default 2
	private boolean prev = false;	// 이전 페이지 화살표
	private boolean next;			// 다음 페이지 화살표
	private int currentBlock = 1;
	private int lastBlock;
		
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCountList() {
		return countList;
	}
	public void setCountList(int countList) {
		this.countList = countList;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getContentNum() {
		return contentNum;
	}
	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int currentBlock) {
		this.startPage = (currentBlock*5)-4;
		// 한 페이지에 5개씩 보여 줌
		// 현재 페이지 블록의 번호 * 블록당 페이지의 개수(5) - 4 = 시작 페이지 번호
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getLastBlock, int getCurrentBlock) {
		if(getLastBlock == getCurrentBlock) {
			this.endPage = calcPage(getTotalCount(), getContentNum());
		}else {
			this.endPage = getStartPage() + 4;
		}
		// 기본 시작 페이지 + 4
		// 조건 , 마지막 페이지 블록이면 마지막 페이지 번호
	}
	public int calcPage(int totalCount, int contentNum) {	// 전체 페이지 수 계산
		int totalPage = totalCount / contentNum;	// 전체 게시물 수를 한 페이지당 몇개로 보이는지로 나눔
		if(totalCount % contentNum > 0) {	// 나머지가 있다면 1을 더해서 한 페이지 증가
			totalPage++;
		}
		if(totalPage<this.pageNum) {
			this.pageNum = totalPage;
		}
		return totalPage; // 페이지 개수를 리턴한다
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int pageNum) {	// 현재 페이지 블록의 번호가 몇번인지 지정, 
		this.currentBlock = pageNum / 5;	// 페이지 번호 / 페이지 개수(5)
		if(pageNum % 5 > 0) {	// 나머지가 있으면 더하기 1 , 이 결과를 현재 블록 번호
			this.currentBlock++;
		}
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(int totalCount) {	// 마지막 페이지 블록의 번호 지정
		this.lastBlock = totalCount / (5*this.contentNum);	// 전체 글 개수를 사용해서 지정
		if(totalCount%(5*this.contentNum)>0) {
			this.lastBlock++;
		}
		// ex) 전체 글 (120) / 페이지 개수 (5) * 한페이지당 글 개수 (10)
		// 나머지가 있으면 더하기 1 
	}
	public void prevNext(int pageNum) {
		if(pageNum > 0 && pageNum > 6) {
			setPrev(false);
			setNext(true);
		}else if(getLastBlock() == getCurrentBlock()) {	// 5개씩 페이지의 그룹번호를 지정
			setPrev(true);	// 그룹 번호가 3이라는 것은 해당 페이지 그룹이 마지막이라는 것이기에 이전 화살표만 활성화
			setNext(false);	// 이 두개가 같다면 마지막 블록이므로 이전만 있고 이후가 없다.
		}else {
			setPrev(true);
			setNext(true);
		}
	}

}
