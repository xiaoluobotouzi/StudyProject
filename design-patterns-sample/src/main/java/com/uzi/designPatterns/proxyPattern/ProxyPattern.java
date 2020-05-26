package com.uzi.designPatterns.proxyPattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 代理模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/21
 * ...
 */
public class ProxyPattern {

    public static void main(String[] args) {
//        StaticProxy staticProxy = new StaticProxy(new RealSubject());
//        staticProxy.request();

        DynaProxyJdk dynaProxyJdk = new DynaProxyJdk();
        ISubject realSubject = dynaProxyJdk.getInstance(new RealSubject());
        realSubject.request();


        DynaProxyCglib dynaProxyCglib = new DynaProxyCglib();
        SubjectObject subjectObject = (SubjectObject) dynaProxyCglib.getInstance(SubjectObject.class);
        subjectObject.request();
    }
}

// 抽象主题角色
interface ISubject{

    void request();
}

// 真实的主题角色 被代理类
class RealSubject implements ISubject{

    @Override
    public void request() {
        System.out.println("  real service is called. ");
    }
}

// 代理主题角色 代理类  静态代理手动实现
class StaticProxy implements ISubject{

    private ISubject subject;

    public StaticProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    private void before() {
        System.out.println("called before request(). ");
    }

    private void after(){
        System.out.println("called after request(). ");
    }
}

// 代理主题角色 代理类  基于JDK的动态代理实现
class DynaProxyJdk implements InvocationHandler{

    private ISubject subject;

    public ISubject getInstance(ISubject subject){
        this.subject = subject;
        Class<?> clazz = subject.getClass();
        return (ISubject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.subject, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("called before request(). ");
    }

    private void after(){
        System.out.println("called after request(). ");
    }
}

// 代理主题角色 代理类  基于 cglib 的动态代理实现
class DynaProxyCglib implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object o1 = methodProxy.invokeSuper(o, objects);
        after();
        return o1;
    }

    private void before() {
        System.out.println("called before request(). ");
    }

    private void after(){
        System.out.println("called after request(). ");
    }
}

// 被代理对象
class SubjectObject{

    public void request(){
        System.out.println("被代理对象类的方法");
    }
}