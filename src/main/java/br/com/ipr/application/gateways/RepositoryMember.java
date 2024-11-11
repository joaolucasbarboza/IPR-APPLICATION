package br.com.ipr.application.gateways;

import br.com.ipr.domain.Member;
import br.com.ipr.infra.persistence.member.MemberEntity;
import java.util.List;
import java.util.Optional;

public interface RepositoryMember {

  Member save(Member member);

  Member association(Member member);

  boolean existsByCpf(String cpf);

  Member findByCpf(String cpf);

  Optional<MemberEntity> findByEmail(String email);

  List<Member> findAll();
}
