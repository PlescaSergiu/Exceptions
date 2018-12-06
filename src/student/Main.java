package student;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {



    public static void main(String... args){

        Constructor_Student student = new Constructor_Student();
        student.addStudent(1948769545787L, 'm',"Tanos", "Felix", 1994, 6, 7);
        student.addStudent(2908765458787L, 'f',"Lanos", "Telix", 1990, 6, 7);




        student.deleteStudent(1678765456787L);
        student.deleteStudent(null);
        student.listStudent();
        System.out.println(student.getAge());
        student.listByFirstNameAndBirthday();




    }
}
