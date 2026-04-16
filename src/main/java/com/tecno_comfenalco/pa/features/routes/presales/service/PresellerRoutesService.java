package com.tecno_comfenalco.pa.features.routes.presales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.features.routes.repository.IPostgresPresalesRoutesRepositoryAdapter;

@Service
public class PresellerRoutesService {
    @Autowired
    IPostgresPresalesRoutesRepositoryAdapter presalesRoutesRepository;

}
