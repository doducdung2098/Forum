package com.hcl.questionandanswermodule.service;

import java.util.List;

public interface DAO<Type1, Type2> {
     Type1 save(Type1 t);
     void deleteById(int id);
     void update(Type1 t);
     List<Type1> findAll(int paged);
}
