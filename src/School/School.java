package School;

import java.util.Arrays;

public class School {
    public static void main(String[] args) {

        Student student1 = new Student("Tom");
        Student student2 = new Student("Jack");
        Student student3 = new Student("Flora");


        Teacher teacherPhysics = new Teacher(Subject.PHYSICS);
        Teacher teacherArt = new Teacher(Subject.ART);
        Teacher teacherHistory = new Teacher(Subject.HISTORY);
        teacherPhysics.teach(student1);
        teacherArt.teach(student2);

        printStudentInfo(student1);
        printStudentInfo(student2);
        printStudentInfo(student3);


        teacherHistory.teach(new Student[]{student2, student1, student3});


        printStudentInfo(student1);
        printStudentInfo(student2);
        printStudentInfo(student3);

        printIfStudentKnows(student3,Subject.HISTORY);
    }

    private static void printStudentInfo(Student student) {
        Subject [] subjects = student.getSubjects();
        for (Subject subject : subjects) {
            if(subject != null) {
                System.out.println(subject.getTeacher() + " taught the Student " + student.getName() + " " + subject.getDescription());
            }

        }
    }

    private static void printIfStudentKnows(Student student, Subject subject) {

        boolean isKnown = student.knows(subject);
        System.out.println(student.getName() + " knows " + subject.name() + " " + subject+ " " + isKnown);


    }

}
