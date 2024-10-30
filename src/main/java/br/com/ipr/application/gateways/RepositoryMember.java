package br.com.ipr.application.gateways;

import br.com.ipr.domain.member.Member;
import java.util.List;

public interface RepositoryMember {

  Member createMember(Member member);

  List<Member> getAllMembers();
}
