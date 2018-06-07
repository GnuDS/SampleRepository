package spring.com.gnus.etc;

public class PageMaker {
	
	private int totalCount;			// ��ü �Խù� ��
	private int countList;			// ����Ʈ ��
	private int pageNum;			// ������ ��ȣ
	private int contentNum = 10;	// �� �������� ���� ����
	private int startPage = 1;		// beginPage default 1
	private int endPage = 5;		// endPage default 2
	private boolean prev = false;	// ���� ������ ȭ��ǥ
	private boolean next;			// ���� ������ ȭ��ǥ
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
		// �� �������� 5���� ���� ��
		// ���� ������ ����� ��ȣ * ��ϴ� �������� ����(5) - 4 = ���� ������ ��ȣ
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
		// �⺻ ���� ������ + 4
		// ���� , ������ ������ ����̸� ������ ������ ��ȣ
	}
	public int calcPage(int totalCount, int contentNum) {	// ��ü ������ �� ���
		int totalPage = totalCount / contentNum;	// ��ü �Խù� ���� �� �������� ��� ���̴����� ����
		if(totalCount % contentNum > 0) {	// �������� �ִٸ� 1�� ���ؼ� �� ������ ����
			totalPage++;
		}
		if(totalPage<this.pageNum) {
			this.pageNum = totalPage;
		}
		return totalPage; // ������ ������ �����Ѵ�
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
	public void setCurrentBlock(int pageNum) {	// ���� ������ ����� ��ȣ�� ������� ����, 
		this.currentBlock = pageNum / 5;	// ������ ��ȣ / ������ ����(5)
		if(pageNum % 5 > 0) {	// �������� ������ ���ϱ� 1 , �� ����� ���� ��� ��ȣ
			this.currentBlock++;
		}
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(int totalCount) {	// ������ ������ ����� ��ȣ ����
		this.lastBlock = totalCount / (5*this.contentNum);	// ��ü �� ������ ����ؼ� ����
		if(totalCount%(5*this.contentNum)>0) {
			this.lastBlock++;
		}
		// ex) ��ü �� (120) / ������ ���� (5) * ���������� �� ���� (10)
		// �������� ������ ���ϱ� 1 
	}
	public void prevNext(int pageNum) {
		if(pageNum > 0 && pageNum > 6) {
			setPrev(false);
			setNext(true);
		}else if(getLastBlock() == getCurrentBlock()) {	// 5���� �������� �׷��ȣ�� ����
			setPrev(true);	// �׷� ��ȣ�� 3�̶�� ���� �ش� ������ �׷��� �������̶�� ���̱⿡ ���� ȭ��ǥ�� Ȱ��ȭ
			setNext(false);	// �� �ΰ��� ���ٸ� ������ ����̹Ƿ� ������ �ְ� ���İ� ����.
		}else {
			setPrev(true);
			setNext(true);
		}
	}

}
