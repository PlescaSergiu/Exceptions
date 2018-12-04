package student;

public class Main {



    public static void main(String... args){

        Constructor_Student student = new Constructor_Student();
        student.addStudent(1678765456787L, 'm',"Tanos", "Felix", 1900, 6, 7);

        student.addStudent(2378765458787L, 'f',"Lanos", "Telix", 1900, 6, 7);



        //student.deleteStudent(1678765456787L);
        //student.deleteStudent(null);
        student.listStudent();
        System.out.println(student.getAge());





    }
}
