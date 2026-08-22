package AbstractClass;

public class UPISystem extends PaymentSystem {
    UPISystem(){
        // Here there is "super()", that is called first. So, we see parent constructor is executing first.
        System.out.println("Called UPISystem Child Constructor");
    }
    @Override
    public void doTxn(){
        System.out.println("UPISystem Transaction is done");
    }
    @Override
    public void suspendTxn(){
        System.out.println("UPISystem Transaction is suspended");
    }
    // Dont override sendSms(), coz, those are some of common functionalities that will stay same for every class, like send sms, after every payment to client
    
}
