package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;
    AdserverClient client;

    //service layer constructor
    @Autowired
    public TaskerServiceLayer(TaskerDao dao, AdserverClient client){
        this.dao = dao;
        this.client = client;
    }

    //takes in and returns a view model
    public TaskViewModel fetchTask(int id) {

        //get the task matching the id from the db
        Task task = dao.getTask(id);
        //create the view model we will return
        TaskViewModel tvm = new TaskViewModel();

        //assign view model values from the stored task
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        //assign ad from adserver using the fiegn client
        tvm.setAdvertisement(client.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        //create a list of all tasks
        List<Task> tasks = dao.getAllTasks();
        //instantiate the list of viewmodels we plan to return
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        //iterate through the list of tasks
        tasks.stream()
                .forEach(task -> {
                    //create a new viewmodel for each task and assign it task values
                    TaskViewModel taskViewModel = new TaskViewModel(task.getDescription(),
                            task.getCreateDate(), task.getDueDate(), task.getCategory());
                    taskViewModel.setId(task.getId());

                    //add ad from adserver feign client to task view model
                    taskViewModel.setAdvertisement(client.getAd());
                    //add view model to list we will return
                    taskViewModels.add(taskViewModel);
                });

        //return list of view models
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        //does the same as find all but starts with only a list of tasks matching the category
        List<Task> tasks = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        tasks.stream()
                .forEach(task -> {
                    TaskViewModel taskViewModel = new TaskViewModel(task.getDescription(),
                            task.getCreateDate(), task.getDueDate(), task.getCategory());
                    taskViewModel.setId(task.getId());
                    taskViewModel.setAdvertisement(client.getAd());
                    taskViewModels.add(taskViewModel);
                });

        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        //create a new task object which we will save to the db
        Task task = new Task();
        //assign view model values to task object
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        //save task to db and assign id to local task object
        task = dao.createTask(task);
        //assign task id to view model object
        taskViewModel.setId(task.getId());
        //add ad from adserver feign client to view model
        taskViewModel.setAdvertisement(client.getAd());

        //return viewmodel
        return taskViewModel;
    }

    public void deleteTask(int id) {
        //deletes task with matching id from the db
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        //create task object and assign it the values from the view model
        Task task = new Task(taskViewModel.getDescription(), taskViewModel.getCreateDate(),
                taskViewModel.getDueDate(), taskViewModel.getCategory());
        task.setId(taskViewModel.getId());

        //use the task object to update the task in the db
        dao.updateTask(task);
    }
}
