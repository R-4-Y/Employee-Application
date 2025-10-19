package exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int employeeId) {
        super("Employee with ID " + employeeId + " not found");
    }

    public EmployeeNotFoundException(String s) {
    }
}
