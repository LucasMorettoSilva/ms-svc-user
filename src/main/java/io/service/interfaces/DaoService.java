package io.service.interfaces;

public interface DaoService<T, PK> {

  void create(T t);

  T read(PK id);

  void update(T t);

  void delete(T t);
}
