package com.students.utils;

import org.springframework.stereotype.Component;

import java.io.File;

public class Path {

    static String s = File.separator;

    //windows平台
    public static String Root ="D:" + s + "Temp" + s + "files" + s;

    /*public static String Root = s + "uploadFile" + s;*/

    //linux平台
    //public static String Root = s + "data" + s + "wwwroot" + s + "default" + s + "rcglk" + s;

    /*public static String DTreeTrainData = "D:"+ File.separator + "JAVA" + File.separator + "file" + File.separator +"dtfile.txt";*/

    public static String DTreeTrainData = Root + "dtfile.txt";

    public static String prize = Root;

    public static String org = Root;

    public static String paper = Root;

    public static String proj = Root;
}
