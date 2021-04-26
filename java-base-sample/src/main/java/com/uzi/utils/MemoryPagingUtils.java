package com.uzi.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MemoryPagingUtils
 * @Description: 内存分页工具类
 * @Author: kunLing
 * @Date 2021/4/13 21:20
 * ...
 */
public class MemoryPagingUtils {

    private MemoryPagingUtils() {
    }

    /**
     * 集合内存分页
     *
     * @param list 需要分页的集合
     * @param page 当前页
     * @param size 每页条数
     * @param <T>
     * @return
     */
    public static <T> List<T> paging(List<T> list, int page, int size) {
        if (null == list || list.isEmpty()) return new ArrayList<>();

        // 总条数
        int totalNum = list.size();

        // 当前页，每页条数，计算总页数
        int pageNum = page;
        int pageSize = size;
        int totalPage = getTotalPage(totalNum, pageSize);

        // 分页
        if (pageNum > totalPage) {
            pageNum = totalPage;
        }
        int startPoint = (pageNum - 1) * pageSize;
        int endPoint = startPoint + pageSize;
        if (totalNum <= endPoint) {
            endPoint = totalNum;
        }
        return list.subList(startPoint, endPoint);
    }

    /**
     * 统一计算总页数算法
     *
     * @param totalNum
     * @param pageSize
     * @return
     */
    public static int getTotalPage(int totalNum, int pageSize) {
        int totalPage = 0;
        if (totalNum > 0) {
            totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        }
        return totalPage;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");

        List<String> paging = paging(list, 22, 2);
        for (String s : paging) {
            System.out.println(s);
        }
    }

}
