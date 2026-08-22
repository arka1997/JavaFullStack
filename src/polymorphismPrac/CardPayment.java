package polymorphismPrac;

public class CardPayment extends Payment{
    
    public void doPayment(){
        validateSomeChecks();
        System.out.println("Card Payment Done");
    }
    public void validateSomeChecks(){
        System.out.println("Some validation checks, once verified, then returned true, for payment");
    }
}
