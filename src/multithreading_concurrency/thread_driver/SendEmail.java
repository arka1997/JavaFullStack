package multithreading_concurrency.thread_driver;


// Another Task, that will be executed by Threads
class SendEmailNotify{
    public void doPayment(){
        System.out.println("Email send notifications by: " + Thread.currentThread().getName());
    }
}

// We could have done this in same class only, that will make a class mess, with all threads, codes. thatswhy we created different reusable modules, for different tasks,
// and make multiple threads assign this same task. And can easily scale tomorrow to create another class like SendSMS, to send sms notifications as well, without disturbing main class, or send notification class
class SendEmail extends Thread{

    @Override
    public void run(){
        System.out.println("SendEmail.run() executing the list of Tasks " + Thread.currentThread().getName());
        // Another task
        SendEmailNotify s = new SendEmailNotify();
        s.doPayment();

        for(int i = 0; i< 5; i++){
            System.out.println("concurrent printing of numbers: " + i + Thread.currentThread().getName());
        }
    }
}
