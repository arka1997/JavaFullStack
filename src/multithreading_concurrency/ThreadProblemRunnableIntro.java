package multithreading_concurrency;

class SendNotification {
    void notification(){
        System.out.println("Sending Notification.......");
    }
}

/**  
 * ❌ PROBLEM: a child class cannot extend 2 parents, multiple inheritanc eis not possible in jAVA
class EmailNotification extends SendNotification extends Thread {
    @Override
    public void run(){

    }
}
*/

public class ThreadProblemRunnableIntro {
    public static void main(String[] args) {
        /** 
            * But there was a problem using Thread. Apart from its reusable architecture and its different ways to achieve reusabality, we had a disadvantage.
            * If there is a parent class, and we want a child to inherit/extend the class. Also want that child class to extend Thread class. 
            * But extending multiple classes by a child class is not possible.
        */
        /*
         * Problem with using Thread:
         *
         * If we already have a parent class:
         *
         *     SendNotification
         *
         * and we want:
         *
         *     EmailNotification
         *
         * to inherit from it,
         *
         * AND we also want EmailNotification to extend Thread,
         * we would need:
         *
         *     EmailNotification extends SendNotification extends Thread
         *
         * ❌ Java does NOT support multiple class inheritance.
         *
         * So a class cannot extend two classes.
         */
    }
}
