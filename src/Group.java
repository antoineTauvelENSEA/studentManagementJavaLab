import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Group {
    static int totalNumberOfGroup=0;
    private String name;
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Group(String name) throws Exception {
        if (!Pattern.matches("[1-2]G[1-3]TD[1-3]TP[1-6]",name))
        { throw new Exception(name + " is not a real ENSEA name");}
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }

    public void addStudent(Student s){
        studentList.add(s);
    }

    public void faireLAppel(){
        System.out.println("********* Liste d'appel du groupe "+name+" *********");
        for (Student s : studentList){
            System.out.println(s);
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void main (String[] args)
    {
        Group a = null,b=null,c= null;
        try{a = new Group("1G1TD1TP1");
            b = new Group("3G1TD1TP1");
            c = new Group("1G1TD1TP2");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        a.addStudent(new Student("Antoine","Tauvel"));
        a.addStudent(new Student("Christophe","Bares"));
        a.addStudent(new Student(args[0],args[1]));

        a.faireLAppel();

        Promotion p = new Promotion("2023");
        p.addGroup(a);
        try {
            a = new Group("1G2TD1TP1");
            p.addGroup(a);
        }
        catch (Exception e){e.printStackTrace();}
        p.findGroup("1G2TD1TP1").faireLAppel();

    }
}
