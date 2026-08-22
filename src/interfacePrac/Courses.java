package interfacePrac;

import java.util.List;

public interface Courses {

    // In interface every methods are by default public and abstract. And variables are public, static and final.
    // Static because, int x = 10, exist only in this class, and from outside it cannot be accessed, as object of the class cannot be created.
    // final becasue interface variables cannot be change are meant to be constants. As if from within the class, the value is changed, then other classes implementing it might get abrupt values.
    public static final int MAX_VALUE = 200;
    int x = 10;
    void instituteName();
    public abstract int studentCount();
    List<String> studentNames();

    public default void programLanguage(){
        System.out.println("We all are here to learn java");
    }
}
