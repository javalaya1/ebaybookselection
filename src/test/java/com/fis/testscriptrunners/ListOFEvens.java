package com.fis.testscriptrunners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOFEvens {

    public static void main(String[] args) {
        List<Integer> allVals = Arrays.asList(15, 14, 10, 11, 14, 12);
        List<Integer> res  = allVals.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x).sorted().distinct().collect(Collectors.toList());
        System.out.println(res);
    }
}


