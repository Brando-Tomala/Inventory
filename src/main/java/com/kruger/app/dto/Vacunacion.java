package com.kruger.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kruger.app.enums.EstadoVacuna;
import com.kruger.app.enums.TipoVacuna;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ApiModel(description = "Modelo Vacunacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Vacunacion {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaVacunacion;

    @Enumerated(EnumType.STRING)
    private EstadoVacuna estadoVacuna;

    @Enumerated(EnumType.STRING)
    private TipoVacuna tipoVacuna;

    @Column(unique = true)
    private Integer numeroDosis;

    @OneToOne
    Usuario usuario;


}
