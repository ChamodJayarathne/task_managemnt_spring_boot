package com.chamod.taskmanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.chamod.taskmanager.dto.request.RequestTaskDto;
import com.chamod.taskmanager.dto.request.UpdateTaskDto;
import com.chamod.taskmanager.dto.response.ResponseTaskDto;
import com.chamod.taskmanager.entity.Task;
import com.chamod.taskmanager.exception.EntryNotFoundException;
import com.chamod.taskmanager.repo.TaskRepo;
import com.chamod.taskmanager.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public void saveTask(RequestTaskDto requestTaskDto) {
        Task task = new Task(
                requestTaskDto.getName(),
                requestTaskDto.getEmployee(),
                requestTaskDto.getStartDate(),
                requestTaskDto.getEndDate(),
                requestTaskDto.getStatus()
        );

        taskRepo.save(task);
    }

    @Override
    public void updateTask(long id, UpdateTaskDto updateTaskDto) {
        Optional<Task> selectedTask = taskRepo.findById(id);
        if (selectedTask.isEmpty()) {
            throw new EntryNotFoundException("Task Not Assigned");
        }
        Task task = selectedTask.get();
        task.setStatus(updateTaskDto.getStatus());

        taskRepo.save(task);
    }

    @Override
    public ResponseTaskDto getTaskById(long id) {
        if(taskRepo.existsById(id)) {
            Task task = taskRepo.getReferenceById(id);

            ResponseTaskDto responseTaskDto = new ResponseTaskDto(
                    task.getId(),
                    task.getName(),
                    task.getEmployee(),
                    task.getStartDate(),
                    task.getEndDate(),
                    task.getStatus()
            );

            return responseTaskDto;
        }
        else {
            throw new RuntimeException("No Task");
        }

    }


    @Override
    public void deleteTask(long id) {
        Optional<Task> selectedTask = taskRepo.findById(id);
        if (selectedTask.isEmpty()) {
            throw new EntryNotFoundException("Not Assign Task");
        }
        taskRepo.deleteById(selectedTask.get().getId());

    }

    @Override
    public List<ResponseTaskDto> getAllTasks() {
        List<Task> taskDtoList = taskRepo.findAll();
        List <ResponseTaskDto> responseTaskDtos = new ArrayList<>();

        for(Task task : taskDtoList){
            ResponseTaskDto responseTaskDto = new ResponseTaskDto(
                    task.getId(),
                    task.getName(),
                    task.getEmployee(),
                    task.getStartDate(),
                    task.getEndDate(),
                    task.getStatus()
            );
            responseTaskDtos.add(responseTaskDto);
        }
        return responseTaskDtos;
    }

    @Override
    public List<ResponseTaskDto> getAllTasksByStatus(String status) {
        List<Task> taskDtoList = taskRepo.findAllByStatus(status);
        List <ResponseTaskDto> responseTaskDtos = new ArrayList<>();

        for(Task task : taskDtoList){
            ResponseTaskDto responseTaskDto = new ResponseTaskDto(
                    task.getId(),
                    task.getName(),
                    task.getEmployee(),
                    task.getStartDate(),
                    task.getEndDate(),
                    task.getStatus()
            );
            responseTaskDtos.add(responseTaskDto);
        }
        return responseTaskDtos;

    }

    @Override
    public List<ResponseTaskDto> getAllTasksByEmployee(String employee) {
        List<Task> taskDtoList = taskRepo.findAllByEmployee(employee);
        List <ResponseTaskDto> responseTaskDtos = new ArrayList<>();

        for(Task task : taskDtoList){
            ResponseTaskDto responseTaskDto = new ResponseTaskDto(
                    task.getId(),
                    task.getName(),
                    task.getEmployee(),
                    task.getStartDate(),
                    task.getEndDate(),
                    task.getStatus()
            );
            responseTaskDtos.add(responseTaskDto);
        }
        return responseTaskDtos;
    }

}
