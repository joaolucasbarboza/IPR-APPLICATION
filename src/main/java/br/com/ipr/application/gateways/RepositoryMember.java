package br.com.ipr.application.gateways;

import br.com.ipr.domain.member.Member;

public interface RepositoryMember {

  Member createMember(Member member);
}
