package com.lamkirich.hospital.Dto;

import com.lamkirich.hospital.Entities.StatusRDV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RendezVousDtoResponse {
    private String id ;
    private Date dateRendezVous ;
    private StatusRDV status ;
}
