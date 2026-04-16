package com.tecno_comfenalco.pa.features.routes.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecno_comfenalco.pa.features.presales.entity.postgres.PresalesEntity;

public interface IPostgresPresalesRoutesRepository extends JpaRepository<PresalesEntity, Long> {
}