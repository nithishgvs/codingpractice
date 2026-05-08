package main.threading;

import java.util.concurrent.Semaphore;

public class PrintInOrder_1114 {

    class Foo {

        private Semaphore secondReady = new Semaphore(0);
        private Semaphore thirdReady = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            secondReady.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            secondReady.acquire();
            printSecond.run();
            thirdReady.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            thirdReady.acquire();
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder_1114 obj = new PrintInOrder_1114();
        Foo foo = obj.new Foo();
        StringBuilder output = new StringBuilder();

        Thread third = new Thread(() -> runMethod(() -> foo.third(() -> output.append("third"))));
        Thread second = new Thread(() -> runMethod(() -> foo.second(() -> output.append("second"))));
        Thread first = new Thread(() -> runMethod(() -> foo.first(() -> output.append("first"))));

        third.start();
        second.start();
        first.start();

        first.join();
        second.join();
        third.join();

        if (!"firstsecondthird".contentEquals(output)) {
            throw new AssertionError("Expected firstsecondthird but got " + output);
        }

        System.out.println(output);
    }

    private static void runMethod(ThrowingRunnable runnable) {
        try {
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private interface ThrowingRunnable {
        void run() throws InterruptedException;
    }
}
