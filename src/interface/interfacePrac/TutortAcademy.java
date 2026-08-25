package interfacePrac;

import java.util.ArrayList;
import java.util.List;

public class TutortAcademy implements Courses{

    @Override
    public void instituteName() {
        System.out.println("Hello I am TutortAcademy");
        
    }

    @Override
    public int studentCount() {
        return 20;
    }

    @Override
    public List<String> studentNames() {
        List<String> l = new ArrayList<>();
        l.add("anki");
        l.add("puku");
        l.add("panchali");
        return l;
    }
}
