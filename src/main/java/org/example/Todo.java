package org.example;

import java.time.LocalDateTime;

public class Todo {
    private static int count = 0;

    private final int id;
    private String title;
    private boolean completed;

    private final LocalDateTime creationDateTime;

    public Todo(String title) {
        this.id = ++count; // Auto-increment ID
        this.completed = false; // Default value
        this.title = title;
        this.creationDateTime = LocalDateTime.now(); // Set creation time to now
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters for other fields
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCompleted(){
        this.setCompleted(true);
    }


    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}
