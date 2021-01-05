package com.first.testgit.utils;

import cn.hutool.core.io.LineHandler;

import java.util.Arrays;
import java.util.List;

/**
 * @author:jiaxingxu
 **/
public class test {
    public static void main(String[] args) {
        test("a","b","c");


    }

    static void test(String ... a){
        List<String> strings = Arrays.asList("a", "e", "f");
        boolean b = Arrays.stream(a).anyMatch(strings::contains);
        strings.contains("a");
        System.out.println(b);

    }

}
