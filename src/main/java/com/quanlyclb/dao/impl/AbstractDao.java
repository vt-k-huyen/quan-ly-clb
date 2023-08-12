package com.quanlyclb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.quanlyclb.dao.GenericDao;
import com.quanlyclb.mapper.RowMapper;

public class AbstractDao<T> implements GenericDao<T>{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); String url =
			 * "jdbc:mysql://localhost:3306/quantri_clb"; String user = "root"; String
			 * password = "1234";
			 */
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection cn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			cn = getConnection();
			statement = cn.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if(cn!= null) {
					cn.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
						statement.setLong(index, (Long)parameter);
				} else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if(parameter instanceof Timestamp ) {
					statement.setTimestamp(index,(Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String sql, Object... parameters) {
			Connection cn = null;
			PreparedStatement statement = null;
			try {
				cn = getConnection();
				cn.setAutoCommit(false);
				statement = cn.prepareStatement(sql);
				setParameter(statement, parameters);
				statement.executeUpdate();
				cn.commit();
			} catch (SQLException e) {
				if(cn != null) {
					try {
						cn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} finally {
				try {
					if(cn!= null) {
						cn.close();
					}
					if(statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection cn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			cn = getConnection();
			cn.setAutoCommit(false);
			statement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			cn.commit();
			return id;
		} catch (SQLException e) {
			if(cn != null) {
				try {
					cn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(cn!= null) {
					cn.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection cn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			cn = getConnection();
			statement = cn.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if(cn!= null) {
					cn.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}
	@Override
	public void insertString(String sql, Object... parameters) {
		Connection cn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			cn = getConnection();
			cn.setAutoCommit(false);
			statement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			if(cn != null) {
				try {
					cn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(cn!= null) {
					cn.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public String insertByID(String sql, Object... parameters) {
		Connection cn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String id = null;
			cn = getConnection();
			cn.setAutoCommit(false);
			statement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getString(1);
			}
			cn.commit();
			return id;
		} catch (SQLException e) {
			if(cn != null) {
				try {
					cn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(cn!= null) {
					cn.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
