package string;
public class StringBuilderTest {

    public static String QUERY = "Select * from Employee";

    public String constructQuery(String empId, int salary){
        StringBuilder build = new StringBuilder(QUERY);
        if(empId != null){
        System.out.println("jhinku");
            build.append(" where employeeId =" + empId);
        }
        return build.toString();
    }

    public static void main(String[] args) {
        StringBuilderTest s = new StringBuilderTest();
        System.out.println(s.constructQuery("QUERY", 500));
    }
}
