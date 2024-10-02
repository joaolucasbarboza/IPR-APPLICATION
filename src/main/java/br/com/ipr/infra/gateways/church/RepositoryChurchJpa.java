package br.com.ipr.infra.gateways.church;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.entities.church.Church;
import br.com.ipr.infra.exceptions.member.MemberNotFound;
import br.com.ipr.infra.persistence.church.ChurchEntity;
import br.com.ipr.infra.persistence.church.ChurchRepository;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.persistence.member.MemberRepository;

import java.util.Optional;

public class RepositoryChurchJpa implements RepositoryChurch {

    private final ChurchRepository repository;
    private final ChurchEntityMapper churchEntityMapper;
    private final MemberRepository memberRepository;

    public RepositoryChurchJpa(ChurchRepository repository, ChurchEntityMapper churchEntityMapper,
                               MemberRepository memberRepository) {
        this.repository = repository;
        this.churchEntityMapper = churchEntityMapper;
        this.memberRepository = memberRepository;
    }

    @Override
    public Church createChurch(Church church) {
        ChurchEntity entity = churchEntityMapper.toEntity(church);

        Optional<MemberEntity> shepherdId = memberRepository.findById(entity.getIdShepherd());

        if (shepherdId.isEmpty()) throw new MemberNotFound();

        repository.save(entity);

        return churchEntityMapper.toDomain(entity);
    }
}
