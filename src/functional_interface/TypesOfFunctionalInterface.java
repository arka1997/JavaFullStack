package functional_interface;

import java.util.Random;
import java.util.function.*;

public class TypesOfFunctionalInterface {
    public static void main(String[] args) {

        // Excepts one Input parameter and process it, and returns a boolean value
        // Predicate
        // ↓
        // I need to ASK a question
        // ↓
        // true / false
        Predicate<Integer> isEligibleForDiscount = (amount) -> amount < 100;
        System.out.println(isEligibleForDiscount.test(5));
        System.out.println(isEligibleForDiscount.negate().test(5));// returns opposite of output
        if (isEligibleForDiscount.test(20)) {
            // applyDiscount();
        }


        // Supplier: No input, process and Generate the output, like generating random numbers for OTP
        // Supplier
        // ↓
        // No input
        // ↓
        // Give me an output
        Supplier<Integer> otpSupplier = () -> 100000 + new Random().nextInt(900000);
        System.out.println("Your OTP is:" + otpSupplier.get());

        //  It accepts an input, consumes it, and does not return any output
        // Consumer
        // ↓
        // Give me something
        // ↓
        // I'll perform an action
        // ↓
        // Nothing returned
        Consumer<String> sendEmail = (emailTo) -> System.out.println("Email Sent to " + emailTo);
        sendEmail.accept("deba@gmail.com");

        // Take the input, do the calculation, give the output
        // Function
        // ↓
        // Take input
        // ↓
        // Process / transform it
        // ↓
        // Return output
        Function<Double, Double> applyDiscount = amount -> amount - (amount * 0.05);
        Double finalAmount = applyDiscount.apply(1000.0);
        System.out.println(finalAmount);
    }
}
