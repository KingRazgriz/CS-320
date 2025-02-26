package TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Task.Task;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        assertNotNull(service.getTask("2225678900"), "Task should be added and retrievable.");
    }

    @Test
    public void testAddDuplicateTask() {
        TaskService service = new TaskService();
        Task task1 = new Task("2225678900", "Task Name", "Task Description");
        Task task2 = new Task("2225678900", "Another Task", "Another Description");
        service.addTask(task1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
        assertEquals("Unique ID must be unique and not invalid.", exception.getMessage(), "Adding a duplicate task should throw an exception.");
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.deleteTask("2225678900");
        assertNull(service.getTask("2225678900"), "Task should be deleted and no longer retrievable.");
    }

    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskName("2225678900", "Updated Task Name");
        assertEquals("Updated Task Name", service.getTask("2225678900").getName(), "Task name should be updated.");
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("2225678900", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTaskDescription("2225678900", "Updated Task Description");
        assertEquals("Updated Task Description", service.getTask("2225678900").getDescription(), "Task description should be updated.");
    }
}