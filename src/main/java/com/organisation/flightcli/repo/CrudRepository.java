package com.organisation.flightcli.repo;
import java.util.*;

public interface CrudRepository<T, ID> {
    void save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
}
