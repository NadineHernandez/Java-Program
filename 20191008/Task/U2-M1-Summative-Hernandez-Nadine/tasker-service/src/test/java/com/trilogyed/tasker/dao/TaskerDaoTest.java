package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskerDaoTest {

    //get access to taskerDao
    @Autowired
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        //clear out test db before each test
        List<Task> tasks = dao.getAllTasks();
        tasks.stream()
                .forEach(task -> dao.deleteTask(task.getId()));
    }

    @Test
    public void createTask() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //save task object to db and assign returnd task with id to local task
        task = dao.createTask(task);

        //assert that local task matches task in db
        assertEquals(task, dao.getTask(task.getId()));
    }

    @Test
    public void getTask() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //save task object to db and assign returnd task with id to local task
        task = dao.createTask(task);

        //assert that local task matches task in db
        assertEquals(task, dao.getTask(task.getId()));
    }

    @Test
    public void getAllTasks() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //add task to db
        dao.createTask(task);

        //assert that size of the list of all tasks is the same as the number of tasks we passed in
        assertEquals(1, dao.getAllTasks().size());
    }

    @Test
    public void getTasksByCategory() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //add task to db
        dao.createTask(task);

        //assert that size of the list of tasks matching category is the same as the number of
        // tasks we passed in with matching category
        assertEquals(1, dao.getTasksByCategory(task.getCategory()).size());
    }

    @Test
    public void updateTask() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //save task object to db and assign returnd task with id to local task
        task = dao.createTask(task);
        //assign updated values to local task
        task.setDescription("Sample description1");
        task.setCreateDate(LocalDate.of(2019, 03, 22));
        task.setDueDate(LocalDate.of(2019, 05, 22));
        task.setCategory("Sample Category1");
        //update task with updated values in db
        dao.updateTask(task);

        //assert that local task matches task from the db
        assertEquals(task, dao.getTask(task.getId()));
    }

    @Test
    public void deleteTask() {
        //create task object that we will store in the db
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        //save task object to db and assign returnd task with id to local task
        task = dao.createTask(task);
        //delete task from db
        dao.deleteTask(task.getId());
        //assert that task is no longer in db
        assertNull(dao.getTask(task.getId()));
    }
}