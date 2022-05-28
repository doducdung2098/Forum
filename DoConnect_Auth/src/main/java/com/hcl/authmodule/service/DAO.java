package com.hcl.authmodule.service;

import java.util.List;

public interface DAO<Type> {
    public Type save(Type t);
    public void deleteById(int id);
    public void update(Type t);
    public List<Type> findAll();
}
