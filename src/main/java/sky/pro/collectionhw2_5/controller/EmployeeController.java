package sky.pro.collectionhw2_5.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.collectionhw2_5.Service.EmployeeService;
import sky.pro.collectionhw2_5.model.Employee;

import java.util.List;

@RestController
@RequestMapping ("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String name,
                                @RequestParam ("lastName") String surname,
                                @RequestParam ("departmentId") int department,
                                @RequestParam  double salary) {
        return employeeService.addEmployee(name, surname, department, salary);

    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String name,
                                @RequestParam ("lastName") String surname) {
        return employeeService.findEmployee(name, surname);

    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String name,
                                 @RequestParam ("lastName") String surname) {
        return employeeService.removeEmployee(name, surname);

    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
