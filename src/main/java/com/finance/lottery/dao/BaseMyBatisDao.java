package com.finance.lottery.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseMyBatisDao<T, PK extends Serializable> {

	T selectByPrimaryKey(PK id);

	void deleteByPrimaryKey(PK id);

	void insert(T entity);

	void insertSelective(T entity);

	void updateByPrimaryKey(T entity);

	void updateByPrimaryKeySelective(T entity);

	List<T> selectList(T entity);

	List<T> selectList(Map<String, Object> paramMap);

}