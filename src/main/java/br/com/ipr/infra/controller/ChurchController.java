package br.com.ipr.infra.controller;

import br.com.ipr.application.usecases.church.CreateChurch;
import br.com.ipr.application.usecases.church.GetAllChurches;
import br.com.ipr.domain.church.Church;
import br.com.ipr.infra.request.ChurchRequestDto;
import br.com.ipr.infra.response.ChurchResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/church")
public class ChurchController {

  private final CreateChurch createChurch;
  private final GetAllChurches getAllChurches;

  public ChurchController(CreateChurch createChurch, GetAllChurches getAllChurches) {
    this.createChurch = createChurch;
    this.getAllChurches = getAllChurches;
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

  @Operation(description = "Exibir todas as igrejas")
  @GetMapping
  public ResponseEntity<List<ChurchResponseDto>> getAll() {
    List<Church> churches = getAllChurches.getAll();

    List<ChurchResponseDto> churchResponseDtos =
        churches.stream().map(ChurchResponseDto::new).toList();

    return ResponseEntity.ok().body(churchResponseDtos);
  }

  @Operation(description = "Exitir uma igreja")
  @GetMapping("/{id}")
  public ResponseEntity<ChurchResponseDto> getById() {
    return null;
  }
}
