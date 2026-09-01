package hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class TicketBooking{
    int ticketId;
    int customerId;
    String customerName;

    TicketBooking(int ticketId, int customerId, String customerName){
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.customerName = customerName;
    }
}
public class SynchronizedHashMap {

    public static void main(String[] args) {

        // Storing 10k TicketBookings in App. Food oRDEING IS ALSO ANOTHER GOOD EXAMPLE
        TicketBooking p = new TicketBooking(1, 5, "Deba");
        TicketBooking p2 = new TicketBooking(2, 7, "puku");
        TicketBooking p3 = new TicketBooking(3,9, "Soumo");
        TicketBooking p4 = new TicketBooking(4, 12, "Bani");
        TicketBooking p5 = new TicketBooking(5, 15, "dilip");
        
        // As HashmAP IS NOT THREAD SAFE, once millions of customers, starts booking or cancelling from the app, then, HashMap being concurrent, there will be problems like, someone booked, the last ticket, but before updating, another customer also booked. Now on whose name will it be booked.
        Map<TicketBooking, Integer> book = new HashMap<>();
        book.put(p,4);
        book.put(p2,8);
        book.put(p3,14);
        book.put(p4,24);

        // Now map is Thread safe. Once a thread start adding/updating, the entire map is locked, until the tHREAD finishes. If there are 1 lakh customer reading/updating bookings at same time, then that small 200ms will also be a huge. So one problem solved, but nother problem came, slowness.
        Map<TicketBooking, Integer> bookSync = Collections.synchronizedMap(book);
        bookSync.put(p5, 2);
        bookSync.remove(p5);

        // Thatswhy we introduced Concurrent HashMap. Here when someone is trying to book ticket(Add), edit and update, then things happen concurrently by multiple Threads. Threads are not blocked to add/read/update, until and unless any Thread is trying to operate at bucket/segment level



    }
}
