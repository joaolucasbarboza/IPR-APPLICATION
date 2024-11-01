package br.com.ipr.infra.controller;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.usecases.ChurchUseCase;
import br.com.ipr.domain.Church;
import br.com.ipr.infra.request.ChurchRequestDto;
import br.com.ipr.infra.response.ChurchResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/church")
public class ChurchController {

  private final RepositoryChurch repositoryChurch;
  private final ChurchUseCase createChurch;
  private final ChurchUseCase churchUseCase;

  public ChurchController(
      ChurchUseCase createChurch, ChurchUseCase churchUseCase, RepositoryChurch repositoryChurch) {
    this.createChurch = createChurch;
    this.churchUseCase = churchUseCase;
    this.repositoryChurch = repositoryChurch;
  }

  @Operation(description = "Criar uma nova igreja (Church).")
  @PostMapping
  @Transactional
  public ResponseEntity<ChurchResponseDto> create(
      @RequestBody ChurchRequestDto requestDto, UriComponentsBuilder uriBuilder) {

    Church salved =
        createChurch.create(
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
    List<Church> churches = churchUseCase.findAll();

    List<ChurchResponseDto> churchResponseDtos =
        churches.stream().map(ChurchResponseDto::new).toList();

    return ResponseEntity.ok().body(churchResponseDtos);
  }

  @Operation(description = "Exibir uma igreja")
  @GetMapping("/{id}")
  public ResponseEntity<ChurchResponseDto> getById(@PathVariable UUID id) {

    Church church = repositoryChurch.findById(id);

    return ResponseEntity.ok().body(new ChurchResponseDto(church));
  }
}
