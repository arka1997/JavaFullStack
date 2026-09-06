package abstractclass;


public class CardSystem extends UPISystem {
    CardSystem(){
        // Here there is "super()", that is called first. So, we see its parent constructor is being called first.
        System.out.println("Called CardSystem Child Constructor");
    }
    @Override
    public void doTxn(){
        System.out.println("CardSystem Transaction is done");
    }
    @Override
    public void suspendTxn(){
        System.out.println(" CardSystem Transaction is suspended");
    }

    // Dont override sendSms(), coz, those are some of common functionalities that will stay same for every class, like send sms, after every payment to client
    
}
