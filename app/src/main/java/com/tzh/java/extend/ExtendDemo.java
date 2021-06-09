package com.tzh.java.extend;

public class ExtendDemo {

    public static void main(String[] args) {
        A a = new C();
        System.out.println(a.x);

    }


}

class A {
    protected String x = "AX";

    {
        System.out.println("A daima kuai :" + x);
    }

    public A() {
        System.out.println(x);
    }
}

class B extends A {
    protected String x = "BX";

    {
        System.out.println("B daima kuai :" + x);
    }

    public B() {
        System.out.println(x);
    }
}

class C extends B {
    protected String x = "Cx";

    {
        System.out.println("c daima kuai :" + x);
    }

    public C() {
        x = "更改";
        System.out.println(x);
    }
}
