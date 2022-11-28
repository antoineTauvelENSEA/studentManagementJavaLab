import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Promotion {
    private String name;
    private ArrayList<Group> groupList;

    public Promotion(String name) {
        this.name = name;
        groupList = new ArrayList<Group>();
    }

    public void addGroup(Group g){
        groupList.add(g);
    }

    public Group findGroup(String s){
        for (Group g : groupList){
            if (g.getName().equals(s)){return g;}
        }
        return null;
    }
    public Student findStudent(Group g, String first, String last){
        for (Student s : g.getStudentList()){
            if (s.getFirstName().equals(first) && s.getLastName().equals(last)){
                return s;
            }
        }
    return null;
    }

    public void fillPromotion(String fileName){
        try{
            FileReader fr= new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            while(s!=null){
                String fields[] = s.split(",");
                System.out.println(fields[0]);
                s=br.readLine();
                Group g=this.findGroup(fields[2]);
                if (g==null){
                    g=new Group(fields[2]);
                    this.addGroup(g);
                }
               // Student stud=this.findStudent(g,fields[1],fields[0]);
               // if (s==null){
                    Student stud=new Student(fields[1],fields[0]);
                    g.addStudent(stud);
               // }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    static public void main (String arg[]){
        Promotion p = new Promotion("2022");
        p.fillPromotion("data/liste2_2020_2021.csv");
    }
}
