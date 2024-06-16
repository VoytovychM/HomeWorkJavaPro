package homework20240612;

import java.lang.reflect.Field;
import java.util.Arrays;

public class School {
    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private Student student1;
    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private Student student2;

    @StudentInfo(name = "Artem", surname = "Stoyanov", age = 45)
    private Student student3;



    public static void main(String[] args) throws IllegalAccessException {
        School school = new School();


        StudentInjector.inject(school);
        System.out.println(school.student1);
        System.out.println(school.student2);
        System.out.println(school.student3);
    }

    static class StudentInjector{
        public static void inject (Object instance) throws IllegalAccessException {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field: fields ) {
                if(field.isAnnotationPresent(StudentInfo.class)){
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    Student student = new Student();
                    student.setName(annotation.name());
                    student.setSurname(annotation.surname());
                    student.setAge(annotation.age());

                    field.set(instance,student);
                }
            }
        }


    }
}

