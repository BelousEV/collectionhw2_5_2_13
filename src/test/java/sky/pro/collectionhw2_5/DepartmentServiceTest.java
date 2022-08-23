package sky.pro.collectionhw2_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.collectionhw2_5.Service.DepartmentService;
import sky.pro.collectionhw2_5.Service.EmployeeService;
import sky.pro.collectionhw2_5.exception.EmployeeNotFoundException;
import sky.pro.collectionhw2_5.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {



    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach() {
        List<Employee> employees = List.of(
                new Employee("Василий", "Васильев", 1, 55_000),
                new Employee("Андрей", "Андреев", 1, 65_000),
                new Employee("Иван", "Иванов", 2, 45_000),
                new Employee("Мария", "Иванова", 2, 50_000),
                new Employee("Ирина", "Андреева", 2, 47_000));
        when(employeeService.getAll()).thenReturn(employees);
    }

    @ParameterizedTest
    @MethodSource ("employeeWithMaxSalaryParams")

    public void employeeWithMaxSalaryPositiveTest (int departmentId, Employee expected) {

        assertThat(departmentService.employeeWithMaxSalary(departmentId)).isEqualTo(expected);
    }

    @Test
    public void employeeWithMaxSalaryNegativeTest () {

        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.employeeWithMaxSalary(3));

    }
    @ParameterizedTest
    @MethodSource ("employeeWithMinSalaryParams")

    public void employeeWithMinSalaryPositiveTest (int departmentId, Employee expected) {

        assertThat(departmentService.employeeWithMinSalary(departmentId)).isEqualTo(expected);;
    }
    @Test
    public void employeeWithMinSalaryNegativeTest () {

        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.employeeWithMinSalary(3));
    }
    @ParameterizedTest
    @MethodSource ("employeesFromDepartmentParams")

    public void employeesFromDepartmentParamsPositiveTest (int departmentId, List<Employee> expected) {
        assertThat(departmentService.employeesFromDepartment(departmentId)).containsExactlyElementsOf(expected);
    }

    @Test
    public void employeesGroupByDepartmentTest () {
        assertThat(departmentService.employeesGroupByDepartment()).containsAllEntriesOf(
                Map.of(
                        1, List.of(new Employee("Василий", "Васильев",1, 55_000), new Employee("Андрей", "Андреев", 1, 65_000)),
                        2, List.of(new Employee("Иван", "Иванов",2, 45_000), new Employee("Мария", "Иванова", 2, 50_000))

                )
                );
    }

    public static Stream<Arguments> employeeWithMaxSalaryParams(){
        return Stream.of(
                Arguments.of(1, new Employee("Андрей", "Андреев", 1, 65_000)),
                Arguments.of(2, new Employee("Мария", "Иванова", 2, 50_000))
        );
    }

    public static Stream<Arguments> employeeWithMinSalaryParams() {
        return Stream.of(
                Arguments.of(1, new Employee("Василий", "Васильев", 1, 55_000)),
                Arguments.of(2, new Employee("Иван", "Иванов", 2, 45_000))
        );
    }

        public static Stream<Arguments> employeesFromDepartmentParams(){
            return Stream.of(
                            Arguments.of(1, List.of(new Employee("Василий", "Васильев",1, 55_000), new Employee("Андрей", "Андреев", 1, 65_000))),
                            Arguments.of(2, List.of(new Employee("Иван", "Иванов",2, 45_000), new Employee("Мария", "Иванова", 2, 50_000))),
                            Arguments.of(3, Collections.emptyList())


                    );

         }
    }
































