package student;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;


public class Student_Catalog implements Student_Interface {

    private static Logger LOGGER = getLogger(Student_Catalog.class.getName());

    private int age; // calculate with method calculateAge

    private Map<Long, Constructor_Student> studentsCatalog = new HashMap<>();


    @Override
    public void addStudent(Long CNP, char sex, String firstName, String lastName, int year, int month, int day) {
        Constructor_Student student = new Constructor_Student();

        studentsCatalog.put(CNP, new Constructor_Student(CNP, sex, firstName, lastName, year, month, day));

    }

    // delete student by CNP
    @Override
    public void deleteStudent(Long CNP) {
        try {
            validateDeletStudent(CNP);
            studentsCatalog.remove(CNP);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listStudent() {
        System.out.println(studentsCatalog);

    }

    //calculate age with give parameters
    private int calculateAge(int year, int month, int day) {
        LocalDate today = LocalDate.now();  //Today's date
        LocalDate birthday = LocalDate.of(year, month, day);  //Birth date
        Period p = Period.between(birthday, today);
        return age = p.getYears();

    }

    public int getAge() {
        return age;
    }

    private void validateDeletStudent(Long CNP) throws ValidationException {
        if (CNP == null || !studentsCatalog.containsKey(CNP)) {
            LOGGER.info("This student does not exist in your catalog");

            throw new ValidationException("You cant delete this student");
        }

    }


}
