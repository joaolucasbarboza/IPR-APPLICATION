package br.com.ipr.infra.response;

import br.com.ipr.domain.Department;

public record DepartmentResponseDto(String name, String description, String image) {
  public DepartmentResponseDto(Department department) {
    this(department.getName(), department.getDescription(), department.getImage());
  }
}
