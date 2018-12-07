package student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;


public class Constructor_Student extends Student_Catalog {

    private static Logger LOGGER = getLogger(Constructor_Student.class.getName());

    private char sex;
    private String firstName;
    private String lastName;
    private int year;
    private int month;
    private int day;
    private String birthday;
    private Long CNP;

    public Constructor_Student() {
    }

    public Constructor_Student(Long CNP, char sex, String firstName, String lastName, int year, int month, int day) {

        try {
            this.CNP = CNP;
            this.sex = sex;
            this.firstName = firstName;
            this.lastName = lastName;
            this.year = year;
            this.month = month;
            this.day = day;
            validateCNP(CNP, year);
            validateAge(year);
            validateFirstNameAndLastName(firstName);
            validateFirstNameAndLastName(lastName);
            validateSex(sex, CNP);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            LOGGER.info("Something was wrong");


        }


    }

    public char getSex() {
        return sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    public String getBirthday() {
        return birthday = (year + "/" + month + "/" + day);
    }

    public Long getCNP() {
        return CNP;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sex=" + sex +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                '}';
    }

    private void validateCatalog(boolean valid) throws ValidationException {
        if (!valid) {
            LOGGER.info("can create");

            throw new ValidationException("Cant add student to catalog");
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
