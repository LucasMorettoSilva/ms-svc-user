package io.model.dao.interfaces;

public interface Dao<T, PK> {

  void create(T t);

  T read(PK pk);

  void update(T t);

  void delete(T t);
}
