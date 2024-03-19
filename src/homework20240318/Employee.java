package homework20240318;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String name;
    private String surname;

    private int age;
    private int workingHoursInMonth;

    public Employee(String name, String surname, int age, int workingHoursInMonth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workingHoursInMonth = workingHoursInMonth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getWorkingHoursInMonth() {
        return workingHoursInMonth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workingHoursInMonth=" + workingHoursInMonth +
                '}';
    }

    @Override
    public int compareTo(Employee another) {
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.surname.compareTo(another.surname);
            if (result == 0) {
                result = Integer.compare(this.age, another.age);
                if (result == 0) {
                    result = Integer.compare(this.workingHoursInMonth, another.workingHoursInMonth);
                }
            }
        }
        return result;
    }


    public static class EmployeeByAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            return Integer.compare(e1.getAge(), e2.getAge());
        }
    }

    public static class EmployeebyNameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            int result = e1.getSurname().compareTo(e2.getSurname());
            if (result == 0) {
                return e1.getName().compareTo(e2.getName());
            }
            return result;
        }
    }

    public static class EmployeebyNameReverseComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    }

    public static class EmployeebyHoursAndAgeReverseComparator implements Comparator<Employee> {

        @Override
        public int compare (Employee e1, Employee e2) {
            int result = Integer.compare(e1.getWorkingHoursInMonth(), e2.getWorkingHoursInMonth());
            if(result==0){
                return Integer.compare(e1.getAge(), e2.getAge());
            }
            return result;
        }
    }
}




