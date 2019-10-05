package com.example.createoc;

public class MyJni {

    static {
        System.loadLibrary("MyJni");
    }

    public native static String getString();
}