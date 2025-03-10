package com.chocs.spring_test.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private int id;
    private int typeId;
    private int subjectId;
    private String description;
    private LocalDate date;

    public Task(int id, int typeId, int subjectId, String description, LocalDate date) {
        this.id = id;
        this.typeId = typeId;
        this.subjectId = subjectId;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id == task.id && typeId == task.typeId && subjectId == task.subjectId && Objects.equals(description, task.description) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, subjectId, description, date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", subjectId=" + subjectId +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
