package com.hcl.chatboxmodule.service;

import java.util.List;
import java.util.Optional;

public interface DAO<Type> {
    public Type save(Type t);
    public void update(Type t);
    public void delete(int id);
    public List<Type> findAll();
    public Optional<Type> findById(int id);
}
