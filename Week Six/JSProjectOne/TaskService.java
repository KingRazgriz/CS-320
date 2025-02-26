package TaskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap;

    // Constructor
    public TaskService() {
        this.taskMap = new HashMap<>();
    }

    // Add Task
    public void addTask(Task task) {
        if (task == null || taskMap.containsKey(task.getUniqueId1())) {
            throw new IllegalArgumentException("Unique ID must be unique and not invalid.");
        }
        taskMap.put((String) task.getUniqueId(), task);
    }

    // Get Task by Unique ID
    public Task getTask(String uniqueId) {
        return taskMap.get(uniqueId);
    }

    // Delete Task
    public void deleteTask(String uniqueId) {
        if (taskMap.remove(uniqueId) == null) {
            throw new IllegalArgumentException("Task with this ID does not exist.");
        }
    }

    // Update Task Name
    public void updateTaskName(String uniqueId, String newName) {
        Task task = taskMap.get(uniqueId);
        if (task == null) {
            throw new IllegalArgumentException("Task with this ID does not exist.");
        }
        task.setName(newName);
    }

    // Update Task Description
    public void updateTaskDescription(String uniqueId, String newDescription) {
        Task task = taskMap.get(uniqueId);
        if (task == null) {
            throw new IllegalArgumentException("Task with this ID does not exist.");
        }
        task.setDescription(newDescription);
    }
}
