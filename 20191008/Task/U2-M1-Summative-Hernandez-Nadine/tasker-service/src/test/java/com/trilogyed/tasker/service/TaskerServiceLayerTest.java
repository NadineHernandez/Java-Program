package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class TaskerServiceLayerTest {
    private TaskerDao taskerDao;
    private AdserverClient client;
    private TaskerServiceLayer taskerServiceLayer;

    //mock the adserver feign client
    private void setupAdserverClientMock(){
        client = mock(AdserverClient.class);
        String ad = "Home Equity Loans @ 3.87% APR";

        //feign client in tests will always return the same string
        doReturn(ad).when(client).getAd();
    }

    //mock the tasker dao
    private void setupTaskerDaoMock(){
        //task object with id that will be returned
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task task = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");
        task.setId(1);

        //task object without id that we expect to be passed in
        Task task1 = new Task("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //list containing task object with id that will return to methods with a List<Task> return type
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory(task.getCategory());
    }



    @Before
    public void setUp() throws Exception {
        setupAdserverClientMock();
        setupTaskerDaoMock();

        taskerServiceLayer = new TaskerServiceLayer(taskerDao, client);
    }

    @Test
    public void fetchTask() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //create new task through service layer and assign returned viewmodel to local variable
        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        //assert that local and fetched view model are the same
        assertEquals(taskViewModel, taskerServiceLayer.fetchTask(taskViewModel.getId()));
    }

    @Test
    public void fetchAllTasks() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //create new task through service layer and assign returned viewmodel to local variable
        taskerServiceLayer.newTask(taskViewModel);


        //assert that the 1 viewmodel we added populates the returned view model list
        assertEquals(1, taskerServiceLayer.fetchAllTasks().size());
    }

    @Test
    public void fetchTasksByCategory() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //create new task through service layer and assign returned viewmodel to local variable
        taskerServiceLayer.newTask(taskViewModel);

        //assert that the 1 viewmodel we added populates the returned view model list
        assertEquals(1, taskerServiceLayer.fetchTasksByCategory(taskViewModel.getCategory()).size());
    }

    @Test
    public void newTask() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //create new task through service layer and assign returned viewmodel to local variable
        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        //assert that local and fetched view model are the same
        assertEquals(taskViewModel, taskerServiceLayer.fetchTask(taskViewModel.getId()));
    }

    @Test
    public void deleteTask() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //assign the id and ad manually
        taskViewModel.setId(1);
        taskViewModel.setAdvertisement(client.getAd());

        //create an argument captor to grab the passed id
        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

        //prepare to capture the passed id when the method deleteTask is used on taskerDao
        doNothing().when(taskerDao).deleteTask(idCaptor.capture());
        //perform delete
        taskerServiceLayer.deleteTask(taskViewModel.getId());

        //verify that the taskerDao was hit one time the deleteTask method using the captured value
        verify(taskerDao, times(1)).deleteTask(idCaptor.getValue());

        //assert that the captured id is equal to the local id we expected to pass
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void updateTask() {
        //create a viewmodel like we'd expect a user to pass in
        TaskViewModel taskViewModel = new TaskViewModel("Sample description", LocalDate.of(2019, 02, 22),
                LocalDate.of(2019, 04, 22), "Sample Category");

        //manually assign id and ad
        taskViewModel.setId(1);
        taskViewModel.setAdvertisement(client.getAd());

        //create argument captor to grab task passed to Dao in update
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);

        //prepare to capture the Task passed when updateTask method is used on taskerDao
        doNothing().when(taskerDao).updateTask(taskCaptor.capture());
        //perform update
        taskerServiceLayer.updateTask(taskViewModel);

        //verify that the taskerDao was hit with the updateTask method one time passing the captured value
        verify(taskerDao, times(1)).updateTask(taskCaptor.getValue());

        //assert that the id of the Task object we captured is equal to the id of the task object attempted to pass
        assertEquals(1, taskCaptor.getValue().getId());
    }
}