package Task;

public class Task {
    private final String uniqueId;
    private String name;
    private String description;

    // Constructor
    public Task(String uniqueId, String name, String description) {
        if (uniqueId == null || uniqueId.length() > 10) {
            throw new IllegalArgumentException("Unique ID must be at least 10 characters long.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name is invalid & cannot exceed 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot exceed 50 characters.");
        }

        this.uniqueId = uniqueId;
        this.name = name;
        this.description = description;
    }

    public String getUniqueId1() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name is invalid and cannot exceed 20 characters.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot exceed 50 characters.");
        }
        this.description = description;
    }

	public Object getUniqueId() {
		// 
		return null;
	}
}
