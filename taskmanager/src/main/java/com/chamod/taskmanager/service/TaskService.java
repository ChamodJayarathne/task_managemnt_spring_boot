package com.chamod.taskmanager.service;

import java.util.List;

import com.chamod.taskmanager.dto.request.RequestTaskDto;
import com.chamod.taskmanager.dto.request.UpdateTaskDto;
import com.chamod.taskmanager.dto.response.ResponseTaskDto;

public interface TaskService {

     void saveTask(RequestTaskDto requestTaskAssignDto);

     void updateTask(long id, UpdateTaskDto updateStatusDto);

     ResponseTaskDto getTaskById(long id);

     void deleteTask(long id);

     List<ResponseTaskDto> getAllTasks();

     List<ResponseTaskDto> getAllTasksByStatus(String status);

     List<ResponseTaskDto> getAllTasksByEmployee(String employee);


}

