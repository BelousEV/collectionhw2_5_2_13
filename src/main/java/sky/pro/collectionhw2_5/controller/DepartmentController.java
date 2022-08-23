package sky.pro.collectionhw2_5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.collectionhw2_5.Service.DepartmentService;
import sky.pro.collectionhw2_5.model.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(@RequestParam ("departmentId") int department) {
        return departmentService.employeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(@RequestParam ("departmentId") int department) {
        return departmentService.employeeWithMinSalary(department);
    }
@GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment (@RequestParam ("departmentId") int department) {
    return departmentService.employeesFromDepartment(department);
}

    @GetMapping(value = "/all")
public Map<Integer, List<Employee>> findEmployees(){

        return departmentService.employeesGroupByDepartment();
    }
}



