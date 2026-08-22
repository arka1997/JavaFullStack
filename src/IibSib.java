class User {

    // Static block
    static {
        System.out.println("User - static block");
    }

    // Instance Initialization Block (IIB), is called once for every single Object, can't call twice for single object
    {
        System.out.println("User IIB");
    }

    // Constructor 1
    public User(String userId) {

        // Calls Constructor 2 of the SAME object, constructor chaining
        this("guest user", userId, "000000000", "abc@xyz.com");

        System.out.println("User.User() - 1");
    }

    // Constructor 2
    public User(String userName, String userId,
                String mobile, String email) {

        // Calls parent constructor
        super();

        System.out.println("User.User() - 2");
    }

    public static void main(String[] args) {

        System.out.println("User.main()");

        User ankit = new User("12345");

        // System.out.println("----- Second Object -----");

        // User ram = new User("67890");
    }
}