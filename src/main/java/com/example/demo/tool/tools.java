package com.example.demo.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tools {
    public static String GetChineseWord(String oriText) {
        String regex = "([\u4e00-\u9fa5]+)";
        String temp = "";
        Matcher matcher = Pattern.compile(regex).matcher(oriText);
        while (matcher.find())
            temp = temp + matcher.group() + ",";
        return temp;
    }

    public static String checktime(String tempString) {
        if (tempString.indexOf("/") > 0)
            tempString = tempString.replace("/", "-");
        String[] temp2 = tempString.split(" ");
        String[] temp3 = temp2[0].split("-");
        if (temp3[1].length() == 1)
            temp3[1] = "0" + temp3[1];
        if (temp3[2].length() == 1)
            temp3[2] = "0" + temp3[2];
        tempString = temp3[0] + "-" + temp3[1] + "-" + temp3[2] + " " + temp2[1];
        return tempString;
    }
}
