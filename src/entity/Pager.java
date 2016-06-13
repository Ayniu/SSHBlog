package entity;

public class Pager {
	private int currentPage; // 当前页
	private int pageSize = 2; // 每页显示
	private int totalSize; // 总的记录数
	private int totalPage; // 总的页数
	private boolean hasFirst; // 是否有第一页
	private boolean hasPrevious; // 是否有上一页
	private boolean hasNext; // 是否有下一页
	private boolean hasLast; // 是否有最后一页
	
	// 构造函数，传递当前页与总的记录数
	public Pager(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
	}
	
	public int getTotalPage() {
		totalPage = totalSize / pageSize;
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public boolean isHasFirst() {
		// 如果当前页为1的话，则没有首页
		if(currentPage == 1)
			return false;
		return true;
	}

	public boolean isHasLast() {
		// 如果当前页等于总页数的话，说明已经是最后一页了
		if(currentPage == getTotalPage()) {
			return false;
		}
		return true;
	}

	public boolean isHasNext() {
		//如果有最后一页的话，就一定有下一页
		if(isHasLast()) {
			return true;
		}
		return false;
	}

	public boolean isHasPrevious() {
		// 如果首页存在的话，一定有前一页
		if(isHasFirst()) {
			return true;
		}
		return false;
	}
	
}
