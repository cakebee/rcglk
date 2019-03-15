package com.students.utils.Pagination;

import org.springframework.stereotype.Service;

@Service("PaginationContext")
public class PaginationContext {
    private static ThreadLocal<Integer> pageNum = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    public static int getPageNum(){
        Integer pn = pageNum.get();
        if(pn == null){
            return 0;
        }
        return pn;
    }

    public static void setPageNum(int pageNumValue){
        pageNum.set(pageNumValue);
    }

    public static void removePageNum() {
        pageNum.remove();
    }

    public static int getPageSize(){
        Integer ps = pageSize.get();
        if(ps == null){
            return 0;
        }
        return ps;
    }

    public static void setPageSize(int pageSizeValue){
        pageSize.set(pageSizeValue);
    }

    public static void removePageSize() {
        pageSize.remove();
    }
}
