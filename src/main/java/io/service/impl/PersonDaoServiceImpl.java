package io.service.impl;

import io.model.dao.impl.JpaPersonDao;
import io.model.entity.Person;
import io.service.interfaces.PersonDaoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PersonDaoServiceImpl implements PersonDaoService {

  @Inject
  private JpaPersonDao userDao;

  @Override
  public List<Person> findAll() {
    return this.userDao.findAll();
  }

  @Override
  public List<Person> findByName(final String name) {
    return this.userDao.findByName(name);
  }

  @Override
  public void create(Person person) {
    this.userDao.create(person);
  }

  @Override
  public Person read(Integer id) {
    return this.userDao.read(id);
  }

  @Override
  public void update(Person person) {
    this.userDao.update(person);
  }

  @Override
  public void delete(Person person) {
    this.userDao.delete(person);
  }
}
