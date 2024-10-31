package br.com.ipr.infra.controller;

import br.com.ipr.application.gateways.RepositoryDepartment;
import br.com.ipr.application.usecases.DepartmentUseCase;
import br.com.ipr.domain.Department;
import br.com.ipr.infra.request.DepartmentRequestDto;
import br.com.ipr.infra.response.DepartmentResponseDto;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  private final RepositoryDepartment repositoryDepartment;
  private final DepartmentUseCase departmentUseCase;

  public DepartmentController(
      RepositoryDepartment repositoryDepartment, DepartmentUseCase departmentUseCase) {
    this.repositoryDepartment = repositoryDepartment;
    this.departmentUseCase = departmentUseCase;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<DepartmentResponseDto> create(
      @RequestBody DepartmentRequestDto dto, UriComponentsBuilder uriBuilder) {

    Department salved =
        departmentUseCase.create(new Department(dto.name(), dto.description(), dto.image()));

    URI uri = uriBuilder.path("/department/{id}").buildAndExpand(salved.getId()).toUri();

    return ResponseEntity.created(uri).body(new DepartmentResponseDto(salved));
  }
}
