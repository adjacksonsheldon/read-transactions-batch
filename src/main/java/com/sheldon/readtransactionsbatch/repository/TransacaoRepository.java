package com.sheldon.readtransactionsbatch.repository;

import com.sheldon.readtransactionsbatch.repository.entity.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository  extends JpaRepository<TransacaoEntity, Long> {
}
