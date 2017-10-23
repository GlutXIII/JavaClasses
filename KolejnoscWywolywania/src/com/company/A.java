package com.company;

import javafx.scene.SubScene;

import java.net.SocketPermission;

public class A {
    public  A() {
        System.out.println("A1");
    }

    public void test() {
        System.out.println("Test");
    }

    {
        System.out.println("I1");
    }
    static{
        System.out.println("IO");
    }

}
