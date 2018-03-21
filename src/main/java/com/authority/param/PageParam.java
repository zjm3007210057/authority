package com.authority.param;

/**
 * 分页查询参数
 * Created by zjm on 21/03/2018.
 */
public class PageParam {

    /**
     * 当前页
     */
    private int currentPage = 1;

    /**
     * 分页大小
     */
    private int pageSize = 10;

    /**
     * 无参构造函数
     */
    public PageParam() {
        this(1, 10);
    }

    /**
     * 构造函数
     * @param currentPage 当前页
     * @param pageSize 分页大小
     */
    public PageParam(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
