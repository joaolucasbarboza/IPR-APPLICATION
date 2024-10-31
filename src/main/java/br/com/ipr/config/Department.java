package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryDepartment;
import br.com.ipr.application.usecases.DepartmentUseCase;
import br.com.ipr.infra.gateways.department.DepartmentEntityMapper;
import br.com.ipr.infra.gateways.department.RepositoryDepartmentImpl;
import br.com.ipr.infra.persistence.department.DepartmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Department {

    @Bean
    DepartmentUseCase departmentUseCase(RepositoryDepartment repositoryDepartment) {
        return new DepartmentUseCase(repositoryDepartment);
    }

    @Bean
    RepositoryDepartmentImpl repositoryDepartmentJpa(DepartmentRepository departmentRepository, DepartmentEntityMapper departmentEntityMapper) {
        return new RepositoryDepartmentImpl(departmentRepository, departmentEntityMapper);
    }

    @Bean
    DepartmentEntityMapper departmentEntityMapper() {
        return new DepartmentEntityMapper();
    }
}
