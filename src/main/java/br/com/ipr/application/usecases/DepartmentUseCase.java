package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryDepartment;
import br.com.ipr.domain.Department;

public class DepartmentUseCase {

  private final RepositoryDepartment repositoryDepartment;

  public DepartmentUseCase(RepositoryDepartment repositoryDepartment) {
    this.repositoryDepartment = repositoryDepartment;
  }

  public Department create(Department department) {
    return repositoryDepartment.create(department);
  }
}
