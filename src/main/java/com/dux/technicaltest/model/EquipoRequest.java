package com.dux.technicaltest.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * EquipoRequest
 */

@JsonTypeName("equipoRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EquipoRequest {

  private String nombre;

  private String liga;

  private String pais;

  public EquipoRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EquipoRequest(String nombre, String liga, String pais) {
    this.nombre = nombre;
    this.liga = liga;
    this.pais = pais;
  }

  public EquipoRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @NotNull 
  @Schema(name = "nombre", example = "River Plate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public EquipoRequest liga(String liga) {
    this.liga = liga;
    return this;
  }

  /**
   * Get liga
   * @return liga
  */
  @NotNull 
  @Schema(name = "liga", example = "Liga Argentina", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("liga")
  public String getLiga() {
    return liga;
  }

  public void setLiga(String liga) {
    this.liga = liga;
  }

  public EquipoRequest pais(String pais) {
    this.pais = pais;
    return this;
  }

  /**
   * Get pais
   * @return pais
  */
  @NotNull 
  @Schema(name = "pais", example = "Argentina", requiredMode = Schema.RequiredMode.REQUIRED)
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
    EquipoRequest equipoRequest = (EquipoRequest) o;
    return Objects.equals(this.nombre, equipoRequest.nombre) &&
        Objects.equals(this.liga, equipoRequest.liga) &&
        Objects.equals(this.pais, equipoRequest.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, liga, pais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipoRequest {\n");
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

