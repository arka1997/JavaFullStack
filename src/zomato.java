public class zomato {
     public static void main(String[] args) throws Exception {
        // String itemName = args[0];
        String priceStr = args[0];
        // String customerName = args[2];
        String customerType = args[1];
        int price = Integer.parseInt(priceStr);
        int cartValue = Integer.parseInt(args[4]);
        if(customerType.equals("premium") && cartValue > 5000){
            price = price - (price*10)/100;
        } else if (customerType.equals("premium") && cartValue > 1000){
            System.out.println("You are eligible for free delivery");
        } else {
            price = price + 30;
        }

            System.out.println(price);
    }
}
