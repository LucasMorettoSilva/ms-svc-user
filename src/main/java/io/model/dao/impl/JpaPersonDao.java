package io.model.dao.impl;

import io.model.dao.interfaces.PersonDao;
import io.model.entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequestScoped
public class JpaPersonDao implements PersonDao {

  @PersistenceContext(name = "jpa-unit")
  private EntityManager em;

  @Override
  public List<Person> findAll() {
    return this.em.createNamedQuery("Person.findAll", Person.class).getResultList();
  }

  @Override
  public List<Person> findByName(String name) {
    return this.em.createNamedQuery("Person.findByName", Person.class)
      .setParameter("name", name)
      .getResultList();
  }

  @Override
  public void create(Person person) {
    this.em.persist(person);
  }

  @Override
  public Person read(final Integer id) {
    return this.em.find(Person.class, id);
  }

  @Override
  public void update(Person person) {
    this.em.merge(person);
  }

  @Override
  public void delete(Person person) {
    if (!this.em.contains(person)) {
      this.em.merge(person);
    }
    this.em.remove(person);
  }
}
