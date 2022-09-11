package com.sheldon.readtransactionsbatch.repository.transacoes;

import com.sheldon.readtransactionsbatch.repository.transacoes.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository  extends JpaRepository<TransacaoEntity, Long> {
}
