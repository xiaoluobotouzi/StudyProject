package com.uzi.jvm;

import sun.misc.Launcher;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @ClassName: JvmClassLoaderSample
 * @Description: TODO
 * @Author: uziJamesi
 * @Date 2020/7/29 22:50
 * ...
 */
public class JvmClassLoaderSample {

    public static void main(String[] args) throws Exception {

//        classLoader();

//        customClassLoader();

        customClassLoaderString();
    }

    /**
     * 自定义类加载器
     * @throws Exception
     */
    private static void customClassLoader() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/studyZiLiao/01_JVM");
        Class clazz = myClassLoader.loadClass("Test");
        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("test", null);
        method.invoke(object, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

    /**
     * 自定义类加载器，打破双亲委派机制，加载自己写的 java.lang.String
     * @throws Exception
     */
    private static void customClassLoaderString() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/studyZiLiao/01_JVM");
        Class clazz = myClassLoader.loadClass("java.lang.String");
        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("test", null);
        method.invoke(object, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

    /**
     * My自定义类加载器
     */
    static class MyClassLoader extends ClassLoader {

        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String fileName) throws Exception {
            String newFileName = fileName.replace(".", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + newFileName + ".class");
            int length = fis.available();
            byte[] bytes = new byte[length];
            fis.read(bytes);
            fis.close();
            return bytes;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                // defineClass 将字节数组转换为类的实例
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        /**
         * 重写 loadClass 打破双亲委派机制
         * @param name
         * @param resolve
         * @return
         * @throws ClassNotFoundException
         */
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();

                    // 就这个 try catch 里的内容，去委托父类加载类的，那就不委托父类，自己尝试去加载
//                    try {
//                        if (parent != null) {
//                            c = parent.loadClass(name, false);
//                        } else {
//                            c = findBootstrapClassOrNull(name);
//                        }
//                    } catch (ClassNotFoundException e) {
//                        // ClassNotFoundException thrown if class not found
//                        // from the non-null parent class loader
//                    }

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        c = findClass(name);

                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    /**
     * 类加载器职责
     */
    private static void classLoader(){
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(JvmClassLoaderSample.class.getClassLoader());

        System.out.println();

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println();

        Launcher launcher = new Launcher();
        System.out.println(launcher.getClassLoader());

        System.out.println();

        System.out.println("bootstrapLoader加载的类文件：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println();

        System.out.println("extClassloader加载的类文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载的类文件：");
        System.out.println(System.getProperty("java.class.path"));
    }
}
