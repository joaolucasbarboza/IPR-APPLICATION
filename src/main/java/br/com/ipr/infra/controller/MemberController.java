package br.com.ipr.infra.controller;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.member.MemberUseCase;
import br.com.ipr.application.usecases.member.MemberChurchAssociationUseCase;
import br.com.ipr.domain.Member;
import br.com.ipr.infra.request.MemberRequestDto;
import br.com.ipr.infra.response.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

  private final RepositoryMember repositoryMember;
  private final MemberUseCase memberUseCase;
  private final MemberChurchAssociationUseCase associationUseCase;

  @Operation(description = "Criar um novo membro.")
  @PostMapping
  @Transactional
  public ResponseEntity<MemberResponseDto> create(
      @RequestBody MemberRequestDto memberRequestDto, UriComponentsBuilder uriBuilder) {

    Member memberSalved = memberUseCase.create(memberRequestDto);
    URI uri = uriBuilder.path("/members/{cpf}").buildAndExpand(memberSalved.getCpf()).toUri();

    return ResponseEntity.created(uri).body(new MemberResponseDto(memberSalved));
  }

  @Operation(description = "Exibir todos os membros")
  @GetMapping
  public ResponseEntity<List<MemberResponseDto>> getAll() {

    List<Member> members = repositoryMember.findAll();

    List<MemberResponseDto> memberResponseDtos =
        members.stream().map(MemberResponseDto::new).toList();

    return ResponseEntity.ok().body(memberResponseDtos);
  }

  @Operation(description = "Associar igreja ao usuario")
  @PostMapping("/{cpf}/church/{churchId}")
  public ResponseEntity<MemberResponseDto> associate(
      @PathVariable String cpf, @PathVariable UUID churchId) {

    Member member = associationUseCase.execute(cpf, churchId);
    return ResponseEntity.ok().body(new MemberResponseDto(member));
  }
}
