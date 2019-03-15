package com.students.utils;

import java.util.Date;

public class Data {
    //未审核状态
    public static Integer unReviewed = 0;
    //审核通过
    public static Integer reviewPass = 1;
    //审核未通过
    public static Integer reviewNotPass = 2;

    public static boolean isValid(String s){
        return s != null && !s.equals("");
    }

    public static boolean isValid(Date date){
        return (date != null);
    }
}
