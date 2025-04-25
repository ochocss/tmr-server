package com.chocs.tmr_server.service;

import com.chocs.tmr_server.domain.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HomePageService {
    protected Connection conn;
    public HomePageService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "java", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> get() {
        List<Task> tasks = new ArrayList<>();

        try {
            ResultSet r = Objects.requireNonNull(conn.createStatement().executeQuery("SELECT * FROM Tasks;"));
            while(r.next()) {
                tasks.add(new Task(r.getInt("ID_task"),
                        r.getInt("ID_type"),
                        r.getInt("ID_subject"),
                        r.getString("Descript"),
                        r.getDate("TaskDate").toLocalDate()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    public ResponseEntity<Void> delete(int id) {
        try {
            conn.createStatement().executeUpdate("DELETE FROM Tasks WHERE ID_task = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
