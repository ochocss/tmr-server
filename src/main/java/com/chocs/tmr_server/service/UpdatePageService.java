package com.chocs.tmr_server.service;

import com.chocs.tmr_server.domain.Task;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class UpdatePageService {
    protected Connection conn;
    public UpdatePageService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "java", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean put(Task task) {
        try {
            conn.createStatement().executeUpdate("UPDATE Tasks SET ID_type = " + task.getTypeId() +
                                                                ", ID_subject = " + task.getSubjectId() + 
                                                                ", Descript = '" + task.getDescription() +
                                                                "', TaskDate = '" + task.getDate() +
                                                                "' WHERE ID_task = " + task.getId() + ";");
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
