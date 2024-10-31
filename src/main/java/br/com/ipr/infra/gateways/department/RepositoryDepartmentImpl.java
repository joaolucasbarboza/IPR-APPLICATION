package br.com.ipr.infra.gateways.department;

import br.com.ipr.application.gateways.RepositoryDepartment;
import br.com.ipr.domain.Department;
import br.com.ipr.infra.persistence.department.DepartmentEntity;
import br.com.ipr.infra.persistence.department.DepartmentRepository;

public class RepositoryDepartmentImpl implements RepositoryDepartment {

  private final DepartmentRepository departmentRepository;
  private final DepartmentEntityMapper departmentEntityMapper;

  public RepositoryDepartmentImpl(
      DepartmentRepository departmentRepository, DepartmentEntityMapper departmentEntityMapper) {
    this.departmentRepository = departmentRepository;
    this.departmentEntityMapper = departmentEntityMapper;
  }

  @Override
  public Department create(Department department) {

    DepartmentEntity departmentEntity = departmentEntityMapper.toDepartmentEntity(department);
    departmentRepository.save(departmentEntity);

    return departmentEntityMapper.toDepartmentDomain(departmentEntity);
  }
}
