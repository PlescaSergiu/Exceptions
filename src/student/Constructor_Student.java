package student;


public class Constructor_Student extends Student_Catalog {

    private char sex;
    private String firstName;
    private String lastName;
    private int year;
    private int month;
    private int day;
    private String birthday;


    Constructor_Student() {
    }

    Constructor_Student(char sex, String firstName, String lastName, int year, int month, int day) {
        this.sex = sex;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.month = month;
        this.day = day;

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


    private String getBirthday() {
        return birthday = (year + "/" + month + "/" + day);
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


}
