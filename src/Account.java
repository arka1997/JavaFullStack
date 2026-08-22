class Test {

    // if we are declaring a final instance variable but not stored any value, then we have to initialize it before a constructor completes initialization, either through IIB, or direct initialize value
    final int MAX_NUMBER;

    {
        this.MAX_NUMBER = 10;
    }

    public static void doSomething(){
        System.out.println("Test");
    }
}

public class Account extends Test{
    
    public static void main(String[] args) {
        Account a = new Account();
        Test t = new Test();
        System.out.println(t.MAX_NUMBER);
    }
}
