package br.com.ipr.infra.request;

import java.util.UUID;

public record ChurchRequestDto(
    String name, String surname, String description, String image, UUID idShepherd) {}
