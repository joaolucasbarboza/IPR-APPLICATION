package br.com.ipr.infra.persistence.church;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChurchRepository extends JpaRepository<ChurchEntity, UUID> {
}
