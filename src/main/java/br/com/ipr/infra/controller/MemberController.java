package br.com.ipr.infra.controller;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.MemberUseCases;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.request.MemberRequestDto;
import br.com.ipr.infra.response.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/members")
public class MemberController {

  private final RepositoryMember repositoryMember;
  private final MemberUseCases createMember;

  public MemberController(MemberUseCases createMember, RepositoryMember repositoryMember) {
    this.createMember = createMember;
    this.repositoryMember = repositoryMember;
  }

  @Operation(description = "Criar um novo membro.")
  @PostMapping
  @Transactional
  public ResponseEntity<MemberResponseDto> create(
      @RequestBody MemberRequestDto dto, UriComponentsBuilder uriBuilder) {

    Member salved =
        createMember.registerMember(
            new Member(
                dto.cpf(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.telephone(),
                dto.gender(),
                dto.birth()));

    URI uri = uriBuilder.path("/members/{cpf}").buildAndExpand(salved.getCpf()).toUri();

    return ResponseEntity.created(uri).body(new MemberResponseDto(salved));
  }

  @Operation(description = "Exibir todos os membros")
  @GetMapping
  public ResponseEntity<List<MemberResponseDto>> getAll() {

    List<Member> members = repositoryMember.getAllMembers();

    List<MemberResponseDto> memberResponseDtos =
        members.stream().map(MemberResponseDto::new).toList();

    return ResponseEntity.ok().body(memberResponseDtos);
  }
}
