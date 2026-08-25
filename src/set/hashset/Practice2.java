package set.hashset;

import java.util.*;

class Employees {
    int salary;
    String role;

    Employees(int salary, String role){
        this.salary = salary;
        this.role = role;
    }

    // Here if hash codes turns out same, or forcefully we make them return same hASHCODE, THEN THAT WILL MAKE COLLISIONS, THEN EQUALS, COMES IN PICTURE
    @Override
    public int hashCode(){
        return Objects.hash(salary,role);
    }
    // eQUALS CHECKS, IF THE CONTENT is same, between the exisiting object in the bucket, and the object that is goint to be inserted in same bucket
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Employees)){
            return false;
        }
        Employees emp = (Employees) obj;
        return this.salary == emp.salary & Objects.equals(this.role, emp.role);
    }

    @Override
    public String toString(){
        return (this.role + " " + this.salary);
    }
}
public class Practice2 {
    public static void main(String[] args) {
        // If in an object, all attributes/property combination is unique, the combination that we define inside hashcode and equals, then it will be considered as a different Object.
        Employees emp = new Employees(2000, "Developer");
        Employees emp2 = new Employees(2000, "Tester");
        Employees emp3 = new Employees(2000, "Coder"); // Here all 4 are different as there combination is different. If we had overrided hashcode() and equals() on basis of salary, then only 1 object is stored, rest objects will be discarded considering duplicates
        Employees emp4 = new Employees(2000, "Designer");

        Set<Employees> empRecord = new HashSet<>();
        empRecord.add(emp);
        empRecord.add(emp2);
        empRecord.add(emp3);
        empRecord.add(emp4);

        // We have to override toString() method of oBJECT class, to print the inner contents, other Object class toString, just give the Object Address
        System.out.println(empRecord);

        System.out.println(empRecord.contains(emp3)); // Takes O(1) Time Complexity, to directly land to bucket, and check, if value exists in Set or not

        Iterator<Employees> itr = empRecord.iterator();
        while(itr.hasNext()){
            Employees empl = itr.next();
            System.out.println(empl.salary + " " + empl.role);
        }
    }
}
