package com.chocs.tmr_server.service;

import com.chocs.tmr_server.domain.Task;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

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
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Tasks (ID_type, ID_subject, Descript, TaskDate) VALUES (?, ?, ?, ?) ;");

            pstmt.setString(1, String.valueOf(task.getTypeId()));
            pstmt.setString(2, String.valueOf(task.getSubjectId()));
            pstmt.setString(3, task.getDescription());
            pstmt.setString(4, task.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
