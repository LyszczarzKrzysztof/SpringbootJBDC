package com.example.jdbccar;

import net.sf.cglib.asm.$AnnotationVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void save(Car car) {
        String sql = "INSERT INTO Car VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                car.getCarId(),
                car.getMark(),
                car.getModel(),
                car.getColor(),
        });

    }

    public List<Map<String, Object>> showByMark(String mark) {
        String sql = "SELECT * FROM Car WHERE mark LIKE ?";

        return jdbcTemplate.queryForList(sql, new Object[]{mark});
    }


    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {

//        String sql = "CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar(255))";
//        getJdbcTemplate().update(sql);

        save(new Car(1L, "Fiat", "126p", "red"));
        save(new Car(2L, "Fiat", "125p", "black"));
        save(new Car(3L, "Audi", "A1", "silver"));
        save(new Car(4L, "Audi", "A2", "white"));
    }
}
