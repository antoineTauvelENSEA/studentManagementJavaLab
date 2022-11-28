public class Student {
    protected String firstName;
    protected String lastName;
    protected static int totalNumberOfStudent=0;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        totalNumberOfStudent++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static int getTotalNumberOfStudent() {
        return totalNumberOfStudent;
    }

    public void finalize(){
        totalNumberOfStudent--;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main (String args[]){
        Student a=new Student("Antoine","Tauvel");
        Student b=new Student("Christophe","Bares");
        Student c=new Student(args[0],args[1]);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("Total number of student "+a.getTotalNumberOfStudent());

        b=c;

        System.gc();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("Total number of student "+a.getTotalNumberOfStudent());


    }
}
