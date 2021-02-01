package com.uzi.javaCollections;

import java.util.*;

/**
 * @ClassName: ListSample
 * @Description: TODO
 * @Author: uziJames
 * @Date 2020/3/16 22:17
 * ...
 */
public class ListSample {

    public static void main(String[] args) {
        listSample();

        setSample();

        mapSample();

    }

    /**
     * map
     */
    public static void mapSample() {
        Map<Object, Object> hashMap = new HashMap<>();
        HashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
    }

    /**
     * set
     */
    public static void setSample() {
        Set<String> hashSet = new HashSet<>();
        HashSet<String> linkenHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
    }

    /**
     * list
     */
    public static void listSample() {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        Vector<String> stack = new Stack<>();
    }
}
