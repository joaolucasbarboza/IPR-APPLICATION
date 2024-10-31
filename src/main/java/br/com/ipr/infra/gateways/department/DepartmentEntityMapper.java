package br.com.ipr.infra.gateways.department;

import br.com.ipr.domain.Department;
import br.com.ipr.infra.persistence.department.DepartmentEntity;
import java.util.List;

public class DepartmentEntityMapper {

  public DepartmentEntity toDepartmentEntity(Department department) {
    return new DepartmentEntity(
        department.getId(),
        department.getName(),
        department.getDescription(),
        department.getImage(),
        department.getQuantMembers());
  }

  public Department toDepartmentDomain(DepartmentEntity departmentEntity) {
    return new Department(
        departmentEntity.getName(),
        departmentEntity.getDescription(),
        departmentEntity.getImage(),
        departmentEntity.getQuantMembers());
  }

  public List<Department> toDepartmentDomain(List<DepartmentEntity> departmentEntityList) {
    return departmentEntityList.stream().map(this::toDepartmentDomain).toList();
  }
}
