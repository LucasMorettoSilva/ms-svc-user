package io.model.dao.interfaces;

import io.model.entity.Person;

import java.util.List;


public interface PersonDao extends Dao<Person, Integer> {

  List<Person> findAll();

  List<Person> findByName(String name);
}
