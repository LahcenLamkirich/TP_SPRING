package com.lamkirich.hospital.Dto;

import com.lamkirich.hospital.Entities.StatusRDV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RendezVousDtoRequest {
    private Date dateRendezVous ;
    private StatusRDV status ;
}
