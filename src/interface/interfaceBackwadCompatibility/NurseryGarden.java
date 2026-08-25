package interfaceBackwadCompatibility;

public interface NurseryGarden {
    public static final int MIN = 200;
    void pots();
    void seeds();
    void fertilizers();
    void pesticides();
    
    // After 5 years, few common functionalities were introduced, that will be implemented by Ugaoo
    public default void loyaltyProgram(){
        System.out.println("Loyalty Program Activated");
    }

}
