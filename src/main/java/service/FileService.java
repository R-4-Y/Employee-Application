package service;

import exception.FileLoadException;
import exception.FileSaveException;
import model.Employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public void saveEmployeesToFile(List<Employee> employees, String filename) throws FileSaveException {
        if (filename == null || employees == null) {
            throw new FileSaveException("Invalid input: parameters cannot be null");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileSaveException("Error saving file: " + e.getMessage());
        }
    }

    public  List<Employee> loadEmployeesFromFile(String filename) throws FileLoadException {
        if(filename == null)
            throw new FileLoadException("String filename is null");

        List<Employee> loadEmployee = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] tmpEmployee = line.split(",");
                    Employee employee = new Employee(Integer.parseInt(tmpEmployee[0]),tmpEmployee[1],tmpEmployee[2],Integer.parseInt(tmpEmployee[3]));
                    loadEmployee.add(employee);
                }catch (Exception e){
                    System.err.println("Error from read : " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new FileLoadException("Error load file: " + e.getMessage());
        }

        return loadEmployee;
    }

}
