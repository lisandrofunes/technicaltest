package com.dux.technicaltest.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * EquipoResponse
 */

@JsonTypeName("equipoResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EquipoResponse {

  private Integer id;

  private String nombre;

  private String liga;

  private String pais;

  public EquipoResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EquipoResponse(Integer id, String nombre, String liga, String pais) {
    this.id = id;
    this.nombre = nombre;
    this.liga = liga;
    this.pais = pais;
  }

  public EquipoResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EquipoResponse nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @NotNull 
  @Schema(name = "nombre", example = "Real Madrid", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public EquipoResponse liga(String liga) {
    this.liga = liga;
    return this;
  }

  /**
   * Get liga
   * @return liga
  */
  @NotNull 
  @Schema(name = "liga", example = "La Liga", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("liga")
  public String getLiga() {
    return liga;
  }

  public void setLiga(String liga) {
    this.liga = liga;
  }

  public EquipoResponse pais(String pais) {
    this.pais = pais;
    return this;
  }

  /**
   * Get pais
   * @return pais
  */
  @NotNull 
  @Schema(name = "pais", example = "España", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pais")
  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipoResponse equipoResponse = (EquipoResponse) o;
    return Objects.equals(this.id, equipoResponse.id) &&
        Objects.equals(this.nombre, equipoResponse.nombre) &&
        Objects.equals(this.liga, equipoResponse.liga) &&
        Objects.equals(this.pais, equipoResponse.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, liga, pais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipoResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    liga: ").append(toIndentedString(liga)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

