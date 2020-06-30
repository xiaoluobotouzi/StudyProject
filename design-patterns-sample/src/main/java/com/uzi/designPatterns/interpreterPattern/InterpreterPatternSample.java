package com.uzi.designPatterns.interpreterPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 解释器模式  -demo
 * @Author: LIU.KL
 * @Date: 2020/6/30
 * ...
 */
public class InterpreterPatternSample {
    public static void main(String[] args) {

    }
}

// 抽象表达式
abstract class Expression{
    abstract void interpret(Context context);
}

// 终结符表达式
class TerminalExpression extends Expression{

    @Override
    void interpret(Context context) {
        System.out.println("终结符表达式解释");
    }
}

// 非终结符表达式
class NonterminalExpression extends Expression{

    private Expression left;
    private Expression right;

    public NonterminalExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    void interpret(Context context) {
        /**
         * 递归调用每一个组成部分的interpret()方法
         * 在递归调用时指定组成部分的连接方式，即非终结符的解释操作
         */
    }
}

// 上下文环境类
class Context{

    // 存储全局信息
    private Map<String, String> map = new HashMap<>();

    public void register(String k, String v){
        // 往上下文环境类中设值
        map.put(k,v);
    }

    public String get(String k){
        // 获取存储在环境类中的值
        return map.get(k);
    }

}