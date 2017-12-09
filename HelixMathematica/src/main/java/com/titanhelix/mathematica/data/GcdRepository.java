package com.titanhelix.mathematica.data;

import org.springframework.data.repository.CrudRepository;

import com.titanhelix.mathematica.data.dao.Gcd;

public interface GcdRepository extends CrudRepository<Gcd, Integer> {

}
