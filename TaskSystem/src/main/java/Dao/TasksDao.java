package Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import Mappers.TaskRowMapper;
 import Model.Task;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;
 

@Component
public class TasksDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Task> getTasks() {
	    String query = "SELECT id, title, description, priority, dueDate, completed, created_at, updated_at, completed_at FROM tasks";
	    return jdbcTemplate.query(query, new TaskRowMapper());
	}
	
	public List<Task> getCompletedTasks() {
	    String query = "SELECT id, title, description, priority, dueDate, completed, created_at, updated_at, completed_at FROM tasks";
	    return jdbcTemplate.query(query, new TaskRowMapper());
	}
	 public Task getTaskById(int taskId) {
	        String query = "SELECT id, title, description, priority, due_date, completed, created_at, updated_at, completed_at " +
	                "FROM tasks " +
	                "WHERE id = ?";

	        return jdbcTemplate.queryForObject(query, new Object[]{taskId}, new TaskRowMapper());
	    }
	 public boolean updateTask(Task task) {
	        String updateSQL = "UPDATE tasks SET title = ?, description = ?, priority = ?, dueDate = ?, completed = ? WHERE id = ?";

	        int result = jdbcTemplate.update(updateSQL,
	                task.getTitle(), task.getDescription(), task.getPriority(), task.getDueDate(), task.isCompleted(), task.getId());

	        return result > 0;
	    }
	 public boolean addTask(Task task) {
		    String insertSQL = "INSERT INTO tasks (title, description, priority, dueDate) VALUES (?, ?, ?, ?)";

	        int result = jdbcTemplate.update(insertSQL, task.getTitle(), task.getDescription(),
	        		task.getPriority() ,task.getDueDate());
	        System.out.println("Number of records inserted: " + result);
	        return result > 0;
	    }
	    public boolean deleteTask(int taskId) {
	        String deleteSQL = "DELETE FROM tasks WHERE id = ?";
	        int result = jdbcTemplate.update(deleteSQL, taskId);
	        System.out.println("Number of records deleted: " + result);
	        return result > 0;
	    }

	    public boolean completeTask(int taskId) {
	        String updateSQL = "UPDATE tasks SET completed = 1 WHERE id = ?";
	        int result = jdbcTemplate.update(updateSQL, taskId);
	        return result > 0;
	    }


}