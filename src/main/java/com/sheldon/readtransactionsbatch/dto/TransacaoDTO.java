package com.sheldon.readtransactionsbatch.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransacaoDTO {
    private String id;
    private BigDecimal valor;
}
