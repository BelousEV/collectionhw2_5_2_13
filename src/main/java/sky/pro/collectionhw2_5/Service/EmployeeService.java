package sky.pro.collectionhw2_5.Service;

import org.springframework.stereotype.Service;
import sky.pro.collectionhw2_5.exception.EmployeeAlreadyAddedException;
import sky.pro.collectionhw2_5.exception.EmployeeNotFoundException;
import sky.pro.collectionhw2_5.exception.EmployeeStorageIsFullException;
import sky.pro.collectionhw2_5.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {

        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }


     public Employee removeEmployee (String name, String surname){
        String key = getKey(name, surname);
          if (!employees.containsKey(key)) {
              throw new EmployeeNotFoundException();
            }
            return employees.remove(key);


        }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    private String getKey(String name,
                          String surname
                          ) {
        return name + "|" + surname;
    }
}

