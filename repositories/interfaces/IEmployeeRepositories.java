package repositories.interfaces;

import entities.BackendDeveloper;
import entities.Employee;

public interface IEmployeeRepositories {
    boolean addEmployee(Employee employee);
    Employee getEmployeeId(int id);
    boolean addProject(BackendDeveloper backendDeveloper);
    boolean dismissEmployee(int id);
    Employee getEmployeeLevel(String level);
}
