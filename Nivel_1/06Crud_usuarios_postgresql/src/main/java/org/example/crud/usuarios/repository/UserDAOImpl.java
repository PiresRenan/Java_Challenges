package org.example.crud.usuarios.repository;

import org.example.crud.usuarios.model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.dao.DataAccessException;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl() {
        this.jdbcTemplate = new JdbcTemplate(dataSource());
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("02535040Rock;,");
        return dataSource;
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
            }
        });
    }

    @Override
    public void updateUser(String variable, int where, String email) {
        String sql = "";

        if (where == 1) {
            sql = "UPDATE users SET id = ? WHERE email = ?";
            int v = Integer.parseInt(variable);
            jdbcTemplate.update(sql, v, email);
        } else {
            sql = switch (where) {
                case 2 -> "UPDATE users SET name = ? WHERE email = ?";
                case 3 -> "UPDATE users SET email = ? WHERE email = ?";
                default -> "UPDATE users SET password = ? WHERE email = ?";
            };
            jdbcTemplate.update(sql, variable, email);
        }


        switch (where) {
            case 1:
                sql = "UPDATE users SET id = ? WHERE email = ?";
                int v = Integer.parseInt(variable);
                jdbcTemplate.update(sql, v, email);
                break;
            case 2:
                sql = "UPDATE users SET name = ? WHERE email = ?";
                jdbcTemplate.update(sql, variable, email);
                break;
            case 3:
                sql = "UPDATE users SET email = ? WHERE email = ?";
                jdbcTemplate.update(sql, variable, email);
                break;
            default:
                sql = "UPDATE users SET password = ? WHERE email = ?";
                jdbcTemplate.update(sql, variable, email);
                break;
        };
    }

    @Override
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, new Object[]{id});
        return rowsAffected > 0;
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            return new User(id, name, email, password);
        }
    }
}