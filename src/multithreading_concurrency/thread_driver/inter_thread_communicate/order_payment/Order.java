package multithreading_concurrency.thread_driver.inter_thread_communicate.order_payment;

import java.util.List;
import java.util.ListIterator;

public class Order extends Thread{
    Task task;
    public Order(Task task) {
        this.task = task;
    }
    
    @Override
    public void run() {
        List<String> l = List.of("Order1","Order2","Order3","Order4","Order5","Order6");
        ListIterator<String> itr = l.listIterator();
        while(itr.hasNext()){
            String val = (String) itr.next();
            task.placingOrder(val);
        }
        super.run();
    }
}
