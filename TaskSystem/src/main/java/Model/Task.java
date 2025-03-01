package Model;

import java.time.LocalDateTime;

public class Task {
	 private int id;
	 private String title;
	 private String description;
	   private String priority;
	 private String  dueDate;
	private boolean completed;
	 private LocalDateTime created_at;
	   private LocalDateTime updated_at;
	  private LocalDateTime completedAt;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", titel=" + title + ", description=" + description + ", priority=" + priority
				+ ", dueDate=" + dueDate + ", completed=" + completed + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", completedAt=" + completedAt + "]";
	}
	  
	  
}
