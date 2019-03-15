package com.students.utils;

import org.springframework.stereotype.Component;

import java.io.File;

public class Path {

    static String s = File.separator;

    //public static String Root = s + "data" + s + "wwwroot" + s + "default" + s + "rcglk" + s;

    public static String DTreeTrainData = "D:"+ File.separator + "JAVA" + File.separator + "file" + File.separator +"dtfile.txt";

    //public static String DTreeTrainData = Root + "dtfile.txt";
}
