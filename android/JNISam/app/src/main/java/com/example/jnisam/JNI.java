package com.example.jnisam;

public class JNI {

    {
        System.loadLibrary("Hello");
    }

    /**
     * 定义native方法
     * 调用代码对应的方法
     * @return
     */
    public native String sayHello();
}
