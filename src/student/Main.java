package student;


import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class Main {
    private static Logger LOGGER = getLogger(Constructor_Student.class.getName());


    public static void main(String... args) {
        LOGGER.info("Start app");
        Constructor_Student student = new Constructor_Student();
        LOGGER.info("User input data");

        student.addStudent(1948769545787L, 'm', "Tanos", "Felix", 1994, 6, 7);
        student.addStudent(2908765458787L, 'f', "Lanos", "Telix", 1990, 6, 7);

        student.deleteStudent(1678765456787L);
        student.deleteStudent(null);
        student.listStudent();


    }


}
