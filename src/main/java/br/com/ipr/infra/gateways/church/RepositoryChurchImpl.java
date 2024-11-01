package br.com.ipr.infra.gateways.church;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.Church;
import br.com.ipr.infra.exceptions.church.NotFoundChurch;
import br.com.ipr.infra.exceptions.member.MemberNotFound;
import br.com.ipr.infra.persistence.church.ChurchEntity;
import br.com.ipr.infra.persistence.church.ChurchRepository;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.persistence.member.MemberRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RepositoryChurchImpl implements RepositoryChurch {

  private final ChurchRepository churchRepository;
  private final ChurchEntityMapper churchEntityMapper;
  private final MemberRepository memberRepository;

  public RepositoryChurchImpl(
      ChurchRepository repository,
      ChurchEntityMapper churchEntityMapper,
      MemberRepository memberRepository) {
    this.churchRepository = repository;
    this.churchEntityMapper = churchEntityMapper;
    this.memberRepository = memberRepository;
  }

  @Override
  public Church createChurch(Church church) {
    ChurchEntity entity = churchEntityMapper.toChurchEntity(church);

    Optional<MemberEntity> shepherdId = memberRepository.findById(entity.getIdShepherd());
    if (shepherdId.isEmpty()) throw new MemberNotFound();

    churchRepository.save(entity);

    return churchEntityMapper.toChurchDomain(entity);
  }

  @Override
  public List<Church> findAll() {

    List<ChurchEntity> entity = churchRepository.findAll();
    return churchEntityMapper.toChurchDomain(entity);
  }

  @Override
  public boolean existsByShepherd(UUID shepherdId) {
    return churchRepository.existsByIdShepherd(shepherdId);
  }

  @Override
  public Church findById(UUID id) {
    ChurchEntity church =
        churchRepository.findById(id).orElseThrow(() -> new NotFoundChurch("Church not found"));

    return churchEntityMapper.toChurchDomain(church);
  }
}
