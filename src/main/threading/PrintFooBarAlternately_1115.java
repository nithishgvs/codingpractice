package main.threading;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately_1115 {

    class FooBar {
        private int n;

        Semaphore fooSemaphore = new Semaphore(1);
        Semaphore barSemaphore = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintFooBarAlternately_1115 obj = new PrintFooBarAlternately_1115();
        FooBar fooBar = obj.new FooBar(5);
        StringBuilder output = new StringBuilder();

        Thread bar = new Thread(() -> runMethod(() -> fooBar.bar(() -> output.append("bar"))));
        Thread foo = new Thread(() -> runMethod(() -> fooBar.foo(() -> output.append("foo"))));

        bar.start();
        foo.start();

        foo.join();
        bar.join();

        String expected = "foobarfoobarfoobarfoobarfoobar";
        if (!expected.contentEquals(output)) {
            throw new AssertionError("Expected " + expected + " but got " + output);
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
