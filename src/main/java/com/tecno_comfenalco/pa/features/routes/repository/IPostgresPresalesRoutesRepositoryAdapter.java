package com.tecno_comfenalco.pa.features.routes.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.tecno_comfenalco.pa.features.routes.ports.IPresalesRoutesRepositoryPort;

@Profile("postgres")
@Repository
public class IPostgresPresalesRoutesRepositoryAdapter implements IPresalesRoutesRepositoryPort {

}
