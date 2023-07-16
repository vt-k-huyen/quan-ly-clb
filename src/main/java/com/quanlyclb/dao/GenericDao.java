package com.quanlyclb.dao;

import java.util.List;

import com.quanlyclb.mapper.RowMapper;

public interface GenericDao<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	String insertByID(String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
