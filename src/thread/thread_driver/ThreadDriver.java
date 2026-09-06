package thread.thread_driver;

public class ThreadDriver {
    
    public static void main(String[] args) {
        System.out.println("Who is executing this code? "+ Thread.currentThread().getName());
        
        System.out.println("main() thread START: "+ Thread.currentThread().getName());
        
        SendEmail t1 = new SendEmail();
        t1.setName("T1");
        t1.start();// chnage it to star, and see, that main is the only thread that is being executing, no new threads are created

        SendEmail t2 = new SendEmail();
        t2.setName("T2");
        t2.start();
        // t2.run(); // is just a method. Calling it directly executes the method on the current thread, that is main() thread. start() is special because it asks
        // the JVM to create a new thread, and that new thread then executes run() Overrided method. If not overriding, nothing happens.
        
        System.out.println("main() thread END: " + Thread.currentThread().getName());


        /** We could have also done this, but it makes the code not clean and mess. But if we repeatedly go on creating such anonymous class threads, then the codes will look very unclean and bad */
        Thread t3 = new Thread() {
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName() + "Some tasks that needs no class, and we can deal with anonymous class, and is just one time");
            }
        };
        t3.start();
    }
}


// If we dont override run method and dont extend Thread class
        // thread_t2.start()
        //     ↓
        // JVM starts a new thread
        //     ↓
        // Thread.run()
        //     ↓
        // Does Thread have a Runnable task?
        //     ↓
        //     NO
        //     ↓
        // run() does nothing
        //     ↓
        // Thread finishes
