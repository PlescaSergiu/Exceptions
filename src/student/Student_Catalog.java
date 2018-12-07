package student;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;


public class Student_Catalog implements Student_Interface {



    private static Logger LOGGER = getLogger(Student_Catalog.class.getName());
    private boolean valid;
    private int age; // calculate with method calculateAge

    private Map<Long, Constructor_Student> studentsCatalog = new HashMap<>();


    @Override
    public void addStudent(Long CNP, char sex, String firstName, String lastName, int year, int month, int day) {
        valid = true;
        try {

            validateCNP(CNP, year);
            validateAge(year);
            validateFirstNameAndLastName(firstName);
            validateFirstNameAndLastName(lastName);
            validateSex(sex, CNP);
            validateCatalog(valid);
            studentsCatalog.put(CNP, new Constructor_Student(sex, firstName, lastName, year, month, day));


        } catch (ValidationException e) {
            valid=false;
            System.out.println(e.getMessage());
            LOGGER.info("Something was wrong");


        }



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
    private void validateCatalog(boolean valid) throws  ValidationException{
        if (!valid ){
            throw new ValidationException("Cant create this student object");
        }
    }

    private void validateDeletStudent(Long CNP) throws ValidationException {
        if (CNP == null || !studentsCatalog.containsKey(CNP)) {
            LOGGER.info("This student does not exist in your catalog");

            throw new ValidationException("You cant delete this student");
        }

    }

    private void validateCNP(Long CNP, int year) throws ValidationException {

        if (CNP == null || !Arrays.asList(13).contains(String.valueOf(CNP).length())) {
            LOGGER.info("user introduced incorect CNP");

            throw new ValidationException("Invalid CNP length");
        }
        if (String.valueOf(CNP).matches("[0-9]")) {
            throw new ValidationException("Invalid CNP length");
        }
        if (String.valueOf(CNP).charAt(1) != String.valueOf(year).charAt(2) || String.valueOf(CNP).charAt(2) != String.valueOf(year).charAt(3)) {
            throw new ValidationException("CNP eror");
        }
    }

    private void validateSex(char sex, long CNP) throws ValidationException {
        if (((Character.toUpperCase(sex)) != 'M') && (Character.toUpperCase(sex) != 'F')) {
            LOGGER.info("The first CNP digit does not match the gender");
            throw new ValidationException("Sex must be M (male) or F(female)");
        }
        if (((Character.toUpperCase(sex)) == ('M')) && String.valueOf(CNP).charAt(0) != '1') {
            LOGGER.info("The first CNP digit does not match the gender");

            throw new ValidationException("For men CNP need to start with 1");
        }
        if (((Character.toUpperCase(sex)) == 'F') && String.valueOf(CNP).charAt(0) != '2') {
            LOGGER.info("The first CNP digit does not match the gender");

            throw new ValidationException("For female CNP need to start with 2");
        }
    }

    private void validateFirstNameAndLastName(String str) throws ValidationException {
        if (str == null || (str.length() < 3 || str.length() > 13)) {
            LOGGER.info("User introduce a incorect first/lastname format");
            throw new ValidationException("Enter valid first name");
        }
        if (!str.matches("[A-Z][a-zA-Z]*")) {
            LOGGER.info("First/lastname must contains only aphabetic letters ");
            throw new ValidationException("First name must contains only aphabetic letters");
        }
    }

    private void validateAge(int year) throws ValidationException {
        if ((year > LocalDate.now().getYear() - 18) || year < 1900) {
            LOGGER.info("Age is over or below");
            throw new ValidationException("A wrong year");
        }
    }


}
