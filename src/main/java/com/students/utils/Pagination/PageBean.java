package com.students.utils.Pagination;

import java.util.List;

public class PageBean<T> {

    private int pageNum ;//第几页
    private int pageSize;//每页显示的记录数
    private long total;//总记录数
    private int pages;//总页数
    private List<T> list;//每页的显示的数据
    private int size;//当前页的数量

    public PageBean(List<T> list){
        this.list = list;
    }

    public PageBean() {
        super();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setCurrPage(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
