package com.myou.jvm.verifys;

/**
 * @Author myou
 * @Date 2020/12/3  5:24 下午
 */
public class JvmLoadClass extends ClassLoader {
    static abstract class Human{
        public abstract void say();
    }

    static class Man extends Human{
        @Override
        public void say() {
            System.out.println("hello man");
        }
    }

    static class Woman extends Human{
        @Override
        public void say() {
            System.out.println("hello woman");
        }
    }

    public void say(Human human){
        System.out.println("hello guy");
    }

    public void say(Man man){
        System.out.println("hello man");
    }

    public void say(Woman woman){
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.say();
        woman.say();
        man = woman;
        man.say();
    }
}
