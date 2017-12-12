package com.titanhelix.mathematica.dataaccess;

import org.springframework.data.repository.CrudRepository;

import com.titanhelix.mathematica.dataaccessobjects.Numbers;

public interface NumbersRepository extends CrudRepository<Numbers, Integer> {

}
