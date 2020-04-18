package com.uzi.javaGenericParadigm;

public class IntegerToolImpl<T> implements ObjectTool<T> {

    @Override
    public void print(T t) {
        System.out.println(t);
    }

}