package com.emezon.transaction.infra.outbound.mysql.jpa.repositories;

import com.emezon.transaction.infra.outbound.mysql.jpa.entities.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMySQLJpaSupplyRepository extends JpaRepository<SupplyEntity, String> {
}
