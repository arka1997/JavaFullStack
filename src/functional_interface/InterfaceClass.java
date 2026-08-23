package functional_interface;

// Functional Interface means, there is a interface class, where only one public abstract method will be there
// Use of functional interface to use lamda expression. Without using method name, implement the single method defined in interface class
// Why use @FunctionalInterface Annotation? So that even before running, and getting the error at runtime of application, we can get the error at compile time, if we do any wrong thing in this functional interface class, like adding 2 methods, then it will let us know prior
// Kind of utility functions, like gst functions,that can be used by many classes of banking, as logic of calculation is same
@FunctionalInterface
public interface InterfaceClass{
    int calc(int a, int b);
}

@FunctionalInterface
interface InterfaceClassNoReturnType{
    void calc(int a, int b);
}

// Old Legacy code, without functional Interface
class ChildClass implements InterfaceClassNoReturnType {

    @Override
    public void calc(int a, int b){
        int sum = a + b;
        System.out.println(sum);
    }
}

class Driver {
    public static void main(String[] args) {
        // Object calling without functional Interface, with much boilerplate codes
        ChildClass c = new ChildClass();
        c.calc(5,6);


        // Object calling with functional Interface but no return type, these is the one line function that you earlier creating in another child class and implementing the functional interface
        InterfaceClassNoReturnType i = (a,b) -> System.out.println(a + b);
        i.calc(5, 6);

        // Object calling with functional Interface with return type, and just 1 line function
        InterfaceClass j = (a,b) -> a + b;
        System.out.println(j.calc(5, 6));

        InterfaceClass k = (a,b) -> {
            int sum = a + b;
            System.out.println(sum);
            return sum;
        };
        System.out.println(k.calc(5, 8));

        InterfaceClassNoReturnType l = (a,b) -> System.out.println(a/b);
        l.calc(4, 6);
    }
}
