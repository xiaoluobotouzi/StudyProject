package com.uzi.javaGenericParadigm;

public class StringToolImpl implements ObjectTool<String> {

    @Override
    public void print(String s) {
        System.out.println(s);
    }

}