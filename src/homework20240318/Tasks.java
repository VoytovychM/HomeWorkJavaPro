package homework20240318;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks {
    public static void main(String[] args) {
        //a) - sort by age - Comparator
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Masha", "Lavrenova", 38, 20));
        employees.add((new Employee("Vova", "Voytovych", 39, 40)));
        employees.add(new Employee("Katia", "Morozova", 37, 30));

        Collections.sort(employees, new Employee.EmployeeByAgeComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        //b) - sort by surname and name - Comparator

        Collections.sort(employees, new Employee.EmployeebyNameComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //c) - natural order by name, surname, age, workingHoursInMonth - Comparable
        System.out.println("Natural order:");

        Collections.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // d) methods getFirstByName(list), getLastByName(list)
        Employee firstByName = EmployeeMethod.getFirstByName(employees);
        System.out.println("First employee by name: " + firstByName);

        Employee lastByName = EmployeeMethod.getLastByName(employees);
        System.out.println("Last employee by name: " + lastByName);

        // 3.а) сортировку по имени в обратном порядке z-a
        System.out.println("Reverse order by Name:");
        Collections.sort(employees, Collections.reverseOrder());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // 3.b) сортировку по рабочим часам и возрасту в обратном порядке
        System.out.println("Reverse order by Working Hours and Age:");
        Collections.sort(employees, new Employee.EmployeebyHoursAndAgeReverseComparator().reversed());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}

