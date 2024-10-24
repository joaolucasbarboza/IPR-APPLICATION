package br.com.ipr.infra.controller;

import br.com.ipr.application.usecases.member.CreateMember;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.request.MemberRequestDto;
import br.com.ipr.infra.response.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final CreateMember createMember;

    public MemberController(final CreateMember createMember) {
        this.createMember = createMember;
    }

    @Operation(description = "Criar um novo membro.")
    @PostMapping
    @Transactional
    public ResponseEntity<MemberResponseDto> create(@RequestBody MemberRequestDto dto,
                                                    UriComponentsBuilder uriBuilder) {

        Member salved = createMember.registerMember(new Member(
                dto.cpf(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.telephone(),
                dto.gender(),
                dto.birth()
        ));

        URI uri = uriBuilder.path("/members/{cpf}").buildAndExpand(salved.getCpf()).toUri();

        return ResponseEntity.created(uri).body(new MemberResponseDto(salved));
    }
}
