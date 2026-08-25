package interfacePrac;

import java.util.ArrayList;
import java.util.List;

public class Kodewala implements Courses{

    @Override
    public void instituteName() {
        System.out.println("Hello I am Kodewala");
        
    }

    @Override
    public int studentCount() {
        return 20;
    }

    @Override
    public List<String> studentNames() {
        List<String> l = new ArrayList<>();
        l.add("Deba");
        l.add("Soumo");
        l.add("Sachin");
        return l;
    }

    @Override
    public void programLanguage(){
        System.out.println("We all are here to learn java from Kodewala");
    }
}
