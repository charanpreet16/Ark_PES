package com.aurousgroup.alphaimplement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurousgroup.alphaimplement.model.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Long>{

}
