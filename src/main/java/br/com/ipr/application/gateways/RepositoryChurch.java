package br.com.ipr.application.gateways;

import br.com.ipr.domain.Church;
import java.util.List;
import java.util.UUID;

public interface RepositoryChurch {

  Church createChurch(Church church);

  List<Church> getAllChurches();

  boolean existsByShepherd(UUID shepherdId);

  Church findById(UUID id);
}
