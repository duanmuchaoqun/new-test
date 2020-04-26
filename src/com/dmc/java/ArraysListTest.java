package com.dmc.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ArraysListTest {

    @Test
    public void testAsList(){
        String[] str = new String[] { "you", "wu" };
        List list = Arrays.asList(str);
        list.add("yangguanbao");
    }

    @Test
    public void testDate(){
        String date = "2020-04-13 10:04:11";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate localDate = LocalDate.parse(date,df);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
    }
}
