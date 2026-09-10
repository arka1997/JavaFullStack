package multithreading_concurrency.thread_driver.inter_thread_communicate.producer_consumer;

public class Task {
    private int number;
    public boolean isDataAvailable = false;
    public synchronized void produceTask(int num) throws InterruptedException {
        System.out.println("Am I starting before wait() was last release or from begining of this block?");
        // Produce task will produce first, and then consume task will consume, so we have to keep a condition where, if by chance thread enters consume, then we will make it wait,
        // But what if? thread enters consume -> and we make thread to wait, then thread comes out of synchronized block, and then release the lock. Again the 2nd thread will start executing, and might end up getting into consumer only, and then get wait. Is SUCH A SCENARIO can OCCUR, OR it doesnot happen here?
        // This doesnot happen as you have tied one thread to do one task only inside Driver class . Like Thread-1 t1 will do producing work only. And Thread-0 t2, will do consuming task only, so the overlapping will never happen
        
        /** Why while(condition) and not if(condition)?
         * while: check → wait → wake → check again → maybe wait again
         * if: check → wait → wake → continue onward
         * What does wait() does?
         * If we made a Consumer Thread to wait. And Producer Thread notifies All, then one of the Consumer Thread will wake up, and acquire the lock, and resume from the next line where last wait() was called.
         * In case of while() thread's last step after wait was the "End of Loop", but ther eis not termination, so it will again check the condition, if data is already consumed by its brothers, then it will again wait. And if not, then it will try to consume.
         * In case of if(), thread's last step after wait was end of if block, and will simply continue to the next step, without checking, if the data is already consumed by its other Consumer brothers. This will cause unexpected crashes or errors, has something already processed by someone, like db connection, or something else, and same thing is again someone trying to do, will waste time or crash, as no data is there for consume, might get null pointer exception
                              ┌─────────────┐
                              │  Producer   │
                              └──────┬──────┘
                                     │
                                     ├── produces ONE item
                                     │
                                     ├── isDataAvailable = true
                                     │
                                     └── notifyAll()
                                             │
                                             ↓
                                  ┌─────────────────────┐
                                  │ Wakes T1, T2, T3    │
                                  └──────────┬──────────┘
                                             │
                                             ↓
                                  T1 acquires the Lock
                                             │
                                             ↓
                                  wait() returns
                                             │
                                             ↓
                              ┌─────────────────────────┐
                              │ Where does execution    │
                              │ go after wait()?        │
                              └────────────┬────────────┘
                                           │
                         ┌─────────────────┴─────────────────┐
                         │                                   │
                         ↓                                   ↓
                ┌─────────────────┐                 ┌─────────────────-┐
                │       IF        │                 │      WHILE       │
                │                 │                 │                  │
                │ if (!data)      │                 │ while (!data)    │
                │     wait();     │                 │     wait();      │
                └────────┬────────┘                 └────────┬─────────┘
                         │                                   │
                         ↓                                   ↓
              wait() returns                  End of while body reached
                         │                                   │
                         ↓                                   ↓
              ┌─────────────────────┐               Go back to the
              │ Go to NEXT LINE     │               while condition
              │                     │                       │
              │ NO re-check of      │                       ↓
              │ isDataAvailable     │              Check condition AGAIN
              └──────────┬──────────┘                       │
                         │                            ┌──────┴──────┐
                         │                            │             │
                         │                            ↓             ↓
                         │                         TRUE          FALSE
                         │                            │             │
                         │                            ↓             ↓
                         │                         wait()        consume()
                         │                         AGAIN             │
                         │                            │              │
                         │                            ↓              ↓
                         │                        WAITING       data consumed
                         │
                         ↓
                    consume()
                         │
                         ↓
              ❌ Problem:
              data may already have
              been consumed by another
              Consumer thread
*/
        while(isDataAvailable){ 
            System.out.println(Thread.currentThread().getName() + " is Waiting ");
            wait();
        }
        // if(isDataAvailable){
        //     System.out.println(Thread.currentThread().getName() + " is Waiting ");
        //     wait();
        // }
        number = num;
        System.out.println(Thread.currentThread().getName() + " Producing " + number);
        notify();
        isDataAvailable = true;
    }
    public synchronized void consumeTask() throws InterruptedException { 
        while(!isDataAvailable){
            System.out.println(Thread.currentThread().getName() + " is Waiting ");
            wait();
        }
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " Consuming " + number);
        number = 0;// If we use "IF" block, then other Consume threads will try to consume data that doesnot exist, and will waste cpu time. While saves the time, by making the thread wait() if data is not Available.
        notify();
        isDataAvailable = false;
    }
}