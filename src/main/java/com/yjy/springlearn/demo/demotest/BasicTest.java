package com.yjy.springlearn.demo.demotest;

import java.util.*;

public class BasicTest {
    public static void main(String[] args) {
        List<List<String>> father = new LinkedList<>();
        List<String> child = new ArrayList<>();
        child.add("before");
        father.add(child);
        child.add("after");
        ListIterator<List<String>> it = father.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
