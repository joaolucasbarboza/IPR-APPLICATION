package br.com.ipr.infra.controller;

import br.com.ipr.application.usecases.church.CreateChurch;
import br.com.ipr.domain.church.Church;
import br.com.ipr.infra.request.ChurchRequestDto;
import br.com.ipr.infra.response.ChurchResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/churchs")
public class ChurchController {

  private final CreateChurch createChurch;

  public ChurchController(CreateChurch createChurch) {
    this.createChurch = createChurch;
  }

  @Operation(description = "Criar uma nova igreja (Church).")
  @PostMapping
  @Transactional
  public ResponseEntity<ChurchResponseDto> create(
      @RequestBody ChurchRequestDto requestDto, UriComponentsBuilder uriBuilder) {

    Church salved =
        createChurch.registerChurch(
            new Church(
                requestDto.name(),
                requestDto.description(),
                requestDto.image(),
                requestDto.idShepherd()));

    URI uri = uriBuilder.path("/churchs/{id}").buildAndExpand(salved.getId()).toUri();

    return ResponseEntity.created(uri).body(new ChurchResponseDto(salved));
  }
}
