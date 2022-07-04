package sky.pro.collectionhw2_5.Service;

import org.springframework.stereotype.Service;
import sky.pro.collectionhw2_5.exception.EmployeeAlreadyAddedException;
import sky.pro.collectionhw2_5.exception.EmployeeNotFoundException;
import sky.pro.collectionhw2_5.exception.EmployeeStorageIsFullException;
import sky.pro.collectionhw2_5.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


     public Employee removeEmployee (String name, String surname){
          Employee employee = new Employee(name, surname);
          if (!employees.contains(employee)) {
              throw new EmployeeNotFoundException();
            }
            employees.remove(employee);
            return employee;

        }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}

