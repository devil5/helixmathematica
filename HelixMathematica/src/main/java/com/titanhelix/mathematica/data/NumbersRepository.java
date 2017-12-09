package com.titanhelix.mathematica.data;

import org.springframework.data.repository.CrudRepository;

import com.titanhelix.mathematica.data.dao.Numbers;

public interface NumbersRepository extends CrudRepository<Numbers, Integer> {

}
