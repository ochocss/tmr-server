package com.chocs.tmr_server.service;

import com.chocs.tmr_server.domain.Task;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RootService {
    protected Connection conn;
    public RootService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "java", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();

        try {
            ResultSet r = Objects.requireNonNull(conn.createStatement().executeQuery("SELECT Name FROM Subjects;"));
            while (r.next()) {
                subjects.add(r.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(subjects);
        return subjects;
    }
}
