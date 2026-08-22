package AbstractClass;

public abstract class PaymentSystem {


    // Defined the abstract blueprint functionalities that a child class needs to implement. Her we define the rules and norms. 
    public abstract void doTxn();
    public abstract void suspendTxn();

    public void sendSms(){
        System.out.println("Send sms from abstract parent class, common for all implemented child classes");
    }
}
