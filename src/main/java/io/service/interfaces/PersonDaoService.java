package io.service.interfaces;

import io.model.entity.Person;

import java.util.List;

public interface PersonDaoService extends DaoService<Person, Integer> {

  List<Person> findAll();

  List<Person> findByName(String name);
}
