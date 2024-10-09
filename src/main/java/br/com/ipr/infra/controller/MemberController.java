package br.com.ipr.infra.controller;

import br.com.ipr.application.usecases.member.CreateMember;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.request.MemberRequestDto;
import br.com.ipr.infra.response.MemberResponseDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final CreateMember createMember;

    public MemberController(final CreateMember createMember) {
        this.createMember = createMember;
    }

    @PostMapping
    @Transactional
    public MemberResponseDto create(@RequestBody MemberRequestDto dto) {
        Member salved = createMember.registerMember(new Member(
                dto.cpf(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.telephone(),
                dto.gender(),
                dto.birth()
        ));

        return new MemberResponseDto(
                salved.getCpf(),
                salved.getName(),
                salved.getEmail(),
                salved.getTelephone(),
                salved.getGender(),
                salved.getBirth(),
                salved.getDateRegistered()
        );
    }
}
