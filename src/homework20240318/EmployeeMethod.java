package homework20240318;

import java.util.List;

public class EmployeeMethod {
    public static Employee getFirstByName (List<Employee> employeeList){
        if(employeeList == null || employeeList.isEmpty()){
            return null;
        }
        Employee firstByNameEmployee = employeeList.get(0);
        for(Employee employee: employeeList){
         if(employee.getName().compareTo(firstByNameEmployee.getName()) < 0){
             firstByNameEmployee = employee;

         }
        }
        return firstByNameEmployee;
    }
     public static Employee getLastByName (List<Employee> employeeList){
        if (employeeList == null || employeeList.isEmpty()){
            return null;

        }
        Employee lastByNameEmployee = employeeList.get(0);
        for(Employee employee: employeeList){
            if(employee.getName().compareTo(lastByNameEmployee.getName()) > 0){
                lastByNameEmployee = employee;
            }
        }
        return lastByNameEmployee;
     }

}
