package TaskService;

import java.util.HashMap;
import java.util.Map;

import Task.Task;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>(); // Ensure the Map uses String as the key

// Add a task with a unique ID
    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getUniqueId())) {
            throw new IllegalArgumentException("Unique ID must be unique and not invalid.");
        }
        tasks.put((String) task.getUniqueId(), task); // Ensure task.getUniqueId() returns a String
    }

// Delete a task by unique ID
    public void deleteTask(String uniqueId) {
        if (uniqueId == null || !tasks.containsKey(uniqueId)) {
            throw new IllegalArgumentException("Unique ID must exist and not be invalid.");
        }
        tasks.remove(uniqueId);
    }

    // Update task name by unique ID
    public void updateTaskName(String uniqueId, String name) {
        if (uniqueId == null || !tasks.containsKey(uniqueId)) {
            throw new IllegalArgumentException("Unique ID must exist and not be invalid.");
        }
        tasks.get(uniqueId).setName(name);
    }

// Update task description by unique ID
    public void updateTaskDescription(String uniqueId, String description) {
        if (uniqueId == null || !tasks.containsKey(uniqueId)) {
            throw new IllegalArgumentException("Unique ID must exist and not be invalid.");
        }
        tasks.get(uniqueId).setDescription(description);
    }

// Get a task by unique ID (for testing purposes)
    public Task getTask(String uniqueId) {
        return tasks.get(uniqueId);
    }
}