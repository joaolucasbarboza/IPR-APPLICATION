package br.com.ipr.infra.persistence.church;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<ChurchEntity, UUID> {}
