package com.authority.model.info;

import java.util.List;

/**
 * 分页信息
 * Created by zjm on 25/01/2018.
 */
public class PageInfo<T> {

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 分页大小
     */
    private int pageSize;

    /**
     * 数据查询起始值
     */
    private int offset;

    /**
     * 记录总数
     */
    private int totalNum;

    /**
     * 总共的页数
     */
    private int totalPage;

    /**
     * 数据
     */
    private List<T> data;

    public PageInfo() {
    }

    public PageInfo(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getOffset(){
        return (this.pageNo - 1) * this.pageSize;
    }

    public int getPageNo() {
        if(pageNo < 1){
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        if(this.pageSize > 0){
            return this.totalNum / this.pageSize + (this.totalNum%this.pageSize > 0 ? 1 : 0);
        }else {
            return 1;
        }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
