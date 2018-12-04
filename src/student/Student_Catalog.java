package student;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Student_Catalog implements Student_Interface {

    private Long CNP;
    private boolean valid;
    private int age;
    //private List<Constructor_Student> studentWithoutCNP = new ArrayList<>();

    private Map<Long, Constructor_Student> studentsCatalog = new HashMap<>();

    @Override
    public void addStudent(Long CNP, char sex, String firstName, String lastName, int year, int month, int day) {
        valid = true;
        try {
            validateCNP(CNP);
            try {
                validateFirstNameAndLastName(firstName);
                try {
                    validateFirstNameAndLastName(lastName);
                    try {
                        validateSex(sex,CNP);
                        try {
                            validateCatalog(valid);

                            studentsCatalog.put(CNP,new Constructor_Student(sex, firstName, lastName, year, month, day));
                            //studentWithoutCNP.add(new Constructor_Student(sex, firstName, lastName, year, month, day));


                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                        valid = false;
                    }
                } catch (ValidationException e) {
                    System.out.println(e.getMessage());
                    valid = false;

                }

            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                valid = false;

            }



        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            valid = false;


        }


    }

    @Override
    public void deleteStudent(Long CNP) {
        try {
            validateDeletStudent(CNP);
            studentsCatalog.remove(CNP);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void listStudent() {
        System.out.println(studentsCatalog);

    }

    private int calculateAge(Constructor_Student student) {
        LocalDate today = LocalDate.now();  //Today's date
        LocalDate birthday = LocalDate.of(student.getYear(),student.getMonth(),student.getDay());  //Birth date
        Period p = Period.between(birthday, today);
        System.out.println(p.getYears());
        return age=p.getYears();

    }

    public int getAge() {
        return age;
    }

    private void validateCatalog(boolean valid) throws ValidationException {
        if (!valid) {
            throw new ValidationException("Cant add student to catalog");
        }
    }

    private void validateCNP(Long CNP) throws ValidationException {

        if (CNP == null || !Arrays.asList(13).contains(String.valueOf(CNP).length())) {
            throw new ValidationException("Invalid CNP length");
        }
        if (String.valueOf(CNP).matches("[0-9]")) {
            throw new ValidationException("Invalid CNP length");
        }

    }

    private void validateSex(char sex, long CNP) throws ValidationException {
        if (((Character.toUpperCase(sex)) != 'M') && (Character.toUpperCase(sex) != 'F')) {
            throw new ValidationException("Sex must be M (male) or F(female)");
        }
        if (((Character.toUpperCase(sex)) == ('M')) && String.valueOf(CNP).charAt(0) != '1') {
            throw new ValidationException("For men CNP need to start with 1");
        }
        if (((Character.toUpperCase(sex)) == 'F') && String.valueOf(CNP).charAt(0) != '2') {
            throw new ValidationException("For female CNP need to start with 2");
        }
    }

    private void validateFirstNameAndLastName(String str) throws ValidationException {
        if (str == null || (str.length() < 3 || str.length() > 13)) {
            throw new ValidationException("Enter valid first name");
        }
        if (!str.matches("[A-Z][a-zA-Z]*")) {
            throw new ValidationException("First name must contains only aphabetic letters");
        }
    }
    
    private void validateDeletStudent(Long CNP) throws ValidationException{
        if(CNP == null || !studentsCatalog.containsKey(CNP)){
            throw new ValidationException("You cant delete this student");
        }

    }
    private void validateAge() throws ValidationException{

    }
}
