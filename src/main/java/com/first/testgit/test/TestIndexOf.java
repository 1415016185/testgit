package com.first.testgit.test;

import java.time.LocalDate;

/**
 * @author:jiaxingxu
 * 有的话为true 没有为false
 **/
public class TestIndexOf {
    public static void main(String[] args) {
        String test="abc";
        System.out.println(test.indexOf("v")!=-1);
        System.out.println(test.contains("v"));
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}
