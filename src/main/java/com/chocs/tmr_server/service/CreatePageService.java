package com.chocs.tmr_server.service;

import com.chocs.tmr_server.domain.Task;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class CreatePageService {
    protected Connection conn;
    public CreatePageService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "java", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean post(Task task) {
        try {
            conn.createStatement().executeUpdate("INSERT INTO Tasks (ID_type, ID_subject, Descript, TaskDate) VALUES " + task.toSqlString() + ";");
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
