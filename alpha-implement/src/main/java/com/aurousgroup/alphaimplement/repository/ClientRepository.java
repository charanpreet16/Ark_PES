package com.aurousgroup.alphaimplement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aurousgroup.alphaimplement.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client , Long>{

}
