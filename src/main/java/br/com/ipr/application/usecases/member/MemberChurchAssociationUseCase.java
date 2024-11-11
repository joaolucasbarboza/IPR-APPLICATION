package br.com.ipr.application.usecases.member;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.Church;
import br.com.ipr.domain.Member;
import java.util.UUID;

import br.com.ipr.infra.exceptions.member.ChurchAlreadyAssociatedException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberChurchAssociationUseCase {

  private final RepositoryMember repositoryMember;
  private final RepositoryChurch repositoryChurch;

  public Member execute(String memberId, UUID churchId) {

    Member member = repositoryMember.findByCpf(memberId);
    Church church = repositoryChurch.findById(churchId);

    if (member.getChurch() != null) {
      if (member.getChurch().getId().equals(church.getId())) {
        throw new ChurchAlreadyAssociatedException(
            String.format(
                "The church %s is already associated with this member %s",
                church.getName(), member.getName()));
      }
    }

    member.setChurch(church);
    return repositoryMember.association(member);
  }
}
