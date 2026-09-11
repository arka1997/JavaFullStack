package multithreading_concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EmailSender implements Callable<String> {
        
    @Override
    public String call(){
        return "Currently I am executing :" + Thread.currentThread().getName();
    }
}
public class CallableExecutorDriver {
    
   public static void main(String[] args) throws InterruptedException, ExecutionException {
      // Also if threads count is less, then submit tasks, then 2 threads will get 2 task, and rest task will be blocked and moved to queue. Once these 2 threads become free, both the threads will be re-used to do the other tasks
      ExecutorService e = Executors.newFixedThreadPool(2);
      // Creating the shared Task object. This is the work I want to handover to the threads of ExecutorService
      EmailSender em = new EmailSender();
      // Here is the thread actually getting created, and we submitted the same shared task to the Thread Pool, just like we did "Thread t1 = new Thread(task)". Threaded Pool recognises each submit as a task, on same shared state/object, and assigns a Thread. Thtshow, multiple threads are working on same shared state concurrently, and now for each Thread we get some return data, that is returned by each thread, and we store them in Future objects, and then get there values to understand which Thread has returned what, what has failed, and which one has passed, and basically log data, or do some processing on those result data
      Future<String> t = e.submit(em);
      Future<String> t1 = e.submit(em);
      // Here if there is an exception by any thread, its wrapped and stored. Later when main tries to get the result, then the exception is thrown back to parent, which is called "Execution Exception".
      Future<String> t2 = e.submit(em);
      // Here Future will basically store the result returned by t3 of the task. Now main will later call the t3.get(), to get the result stored in Furture -> referenceing to -> FutureTask. Thatswhy the name is Future,a s result is stored, later main retrieves it by calling get() method. Whereas in traditional method call,w e directly return the result back to main, not storing anywhere.
      Future<String> t3 = e.submit(em);
      System.out.println("This thread " + Thread.currentThread().getName() + " returns result => " + t.get());// This .get is blocking in nature, lets say, a thread is taing time, may went to sleep, then this get will not retrive any value and will be in blocked state
      System.out.println("This thread " + Thread.currentThread().getName() + " returns result => " + t1.get());
      System.out.println("This thread " + Thread.currentThread().getName() + " returns result => " + t2.get());
      System.out.println("This thread " + Thread.currentThread().getName() + " returns result => " + t3.get());
      e.shutdown();
   }
}

/**
 * Earlier we were creating multiple threads manually. We cant reuse the threads, that has done the work. earlier it was not done
 */
/** 
Future<String> f = e.submit(em);

┌─────────────────────────────┐
│ FutureTask<String>          │
│                             │
│ Callable = EmailSender      │
│                             │
│ Result = ???                │
│ Exception = ???             │
│ State = NOT COMPLETED       │
└─────────────────────────────┘

main
 │
 │
 ↓
Future f
 │
 └──────────────→ FutureTask

 4. Then what does the worker thread do?

 Worker-1
   │
   │ "Is there a task?"
   ↓
Queue
   │
   │ Task available
   ↓
takes FutureTask
   │
   ↓
runs it

Then internally the FutureTask executes your Callable:

Worker-1
   │
   ↓
FutureTask.run()
   │
   ↓
Callable.call()
   │
   ↓
return "I am Callable"

5. Where does "I am Callable" go?

It does NOT do:

Worker-1
   ↓
return
   ↓
main()

### Instead

Worker-1
   │
   ↓
call()
   │
   ↓
"I am Callable"
   │
   ↓
FutureTask stores the result

┌─────────────────────────────┐
│ FutureTask                  │
│                             │
│ Result: "I am Callable"     │ ← stored here
│                             │
│ Status: COMPLETED           │
└─────────────────────────────┘

6. Then main() calls f.get()
f points to that particular FutureTask.
MAIN
 │
 │ f.get()
 ↓
FutureTask
 │
 ├── Is task finished?
 │
 └── YES
      ↓
"I am Callable"
      ↓
MAIN

*/