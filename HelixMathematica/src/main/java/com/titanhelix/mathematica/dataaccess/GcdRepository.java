package com.titanhelix.mathematica.dataaccess;

import org.springframework.data.repository.CrudRepository;

import com.titanhelix.mathematica.dataaccessobjects.Gcd;

public interface GcdRepository extends CrudRepository<Gcd, Integer> {

}
