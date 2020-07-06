package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Collection<Accident> findAllAccidents() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    public void create(Accident accident) {
        jdbc.update("insert into accident (name, text, address) values (?, ?, ?)",
                accident.getName(),
                accident.getText(),
                accident.getAddress());
    }

    public Accident findById(int id) {
        return jdbc.queryForObject("select id, name, text, address from accident where id = ?",
                (resultSet, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setId(resultSet.getInt("id"));
                    accident.setName(resultSet.getString("name"));
                    accident.setText(resultSet.getString("text"));
                    accident.setAddress(resultSet.getString("address"));
                    return accident;
                },
                id);
    }

    public void update(Accident accident) {
        jdbc.update("update accident set name = ?, text = ?, address = ? where id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getId());
    }
}
