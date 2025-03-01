package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.TasksDao;
import Model.Task;

@Service
public class TasksService {
 @Autowired
 private TasksDao tasksDao;

public TasksService() {

}

public boolean updateTask(Task task) {
	return tasksDao.updateTask(task);
}

public List<Task> gettasks() {
	return tasksDao.getTasks();
}

public List<Task> getCompletedTasks() {
	return tasksDao.getCompletedTasks();
}

public void addTask(Task task) {
	 tasksDao.addTask(task);
}

public Task getTaskById(int taskId) {
	return tasksDao.getTaskById(taskId);
}

public boolean deleteTask(int taskId) {
	return tasksDao.deleteTask(taskId);
}

public boolean completeTask(int taskId) {
	return tasksDao.completeTask(taskId);
}
}
