package student;

public interface Student_Interface {



    void addStudent(Long CNP,char sex, String firstName, String lastName, int year, int month, int day);

    void deleteStudent(Long CNP);

    void listStudent();


}
