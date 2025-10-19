import model.Employee;
import service.EmployeeService;
import service.FileService;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee(1,"Рик","Санчез",99_000);
        Employee employee2 = new Employee(2,"Джеймс","Гослинг",500_000);
        Employee employee3 = new Employee(3,"Роб","Пайк",480_000);
        Employee employee4 = new Employee(4,"Бьярне","Страуструп",320_000);
        Employee employee5 = new Employee(5,"Егов","Летов",70_000);
        Employee employee6 = new Employee(6,"Константин","Ступин",45_000);
        Employee employee7 = new Employee(7,"Билл","Гейтс",5_000_000);
        Employee employee8 = new Employee(8,"Линус","Торвальдс",600_000);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);

        System.out.println(new EmployeeService().getEmployeeById(8,employeeList));
        //System.out.println(new EmployeeService().getEmployeeById(12,employeeList));
        System.out.println(new EmployeeService().getEmployeesBySalaryGreaterThan(500000,employeeList));

        System.out.println(new EmployeeService().getEmployeeMap(employeeList));

        new FileService().saveEmployeesToFile(employeeList, "test.txt");
        System.out.println(new FileService().loadEmployeesFromFile("test.txt"));




    }
}
