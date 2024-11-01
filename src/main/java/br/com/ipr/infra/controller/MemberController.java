package br.com.ipr.infra.controller;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.MemberUseCase;
import br.com.ipr.domain.Member;
import br.com.ipr.infra.request.MemberRequestDto;
import br.com.ipr.infra.response.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

  private final RepositoryMember repositoryMember;
  private final MemberUseCase memberUseCase;

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
}
