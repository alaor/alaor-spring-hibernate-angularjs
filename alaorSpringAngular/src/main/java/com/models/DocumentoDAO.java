package com.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alaor on 30/10/15.
 */
@Transactional
public interface DocumentoDAO extends CrudRepository<Documento, Long> {

    public Documento findById(Long id);

}