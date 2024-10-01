package br.com.ipr.infra.persistence.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {
}
