package com.students.utils;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class Data {
    //未审核状态
    public static Integer unReviewed = 0;
    //审核通过
    public static Integer reviewPass = 1;
    //审核未通过
    public static Integer reviewNotPass = 2;

    public static Set<Integer> status = new HashSet<Integer>(){
        {
            add(unReviewed);
            add(reviewPass);
            add(reviewNotPass);
        }
    };

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static Validator validator = validatorFactory.getValidator();

    public static boolean isStatusValid(Integer s) { return status.contains(s); }

    public static boolean isValid(String s){
        return s != null && !s.equals("");
    }

    public static boolean isValid(Date date){
        return (date != null);
    }

    public static boolean isValid(Integer i){ return i != null; }

    public static Date stringToShortDate(String date){
        System.out.println(date);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat format2 = new SimpleDateFormat("yyyy-M-d");
        Date newDate = null;

        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        try{
            System.out.println(1);
            newDate = format.parse(date);
        }catch (ParseException e){
            try {
                System.out.println(2);
                newDate = format1.parse(date);
            }catch (ParseException e1){
                try {
                    System.out.println(3);
                    newDate = format2.parse(date);
                }catch (ParseException e2){
                    e2.printStackTrace();
                }

            }
        }
        System.out.println("更改后"+newDate);
        return  newDate;
    }
}
