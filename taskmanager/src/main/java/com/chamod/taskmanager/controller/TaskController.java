
package com.chamod.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.chamod.taskmanager.dto.request.RequestTaskDto;
import com.chamod.taskmanager.dto.request.UpdateTaskDto;
import com.chamod.taskmanager.dto.response.ResponseTaskDto;
import com.chamod.taskmanager.service.impl.TaskServiceImpl;
import com.chamod.taskmanager.util.StandardResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = "http://localhost:5173")

public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping(path = "/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> saveTask(@RequestBody RequestTaskDto requestTaskDto){
        taskService.saveTask(requestTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Task Assign to a member!",requestTaskDto.getName()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<StandardResponse> findTask(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Task Assigned data!",taskService.getTaskById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/update/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<StandardResponse> updateTask(
            @PathVariable(value = "id") long id,
            @RequestBody UpdateTaskDto requestUpdateStatusDto
            ){
        taskService.updateTask(id,requestUpdateStatusDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"updated data!",requestUpdateStatusDto.getStatus()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> deleteTask(@PathVariable(value = "id") long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"deleted data!",id),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(path = "/get-all-tasks")
    public ResponseEntity<StandardResponse> getAllTasks() {
        List<ResponseTaskDto> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All Tasks", allTasks), HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-status/{status}")
    public ResponseEntity<StandardResponse> getAllTasksByStatus(
            @PathVariable(value = "status") String status) throws ChangeSetPersister.NotFoundException {
        List<ResponseTaskDto> allStatus = taskService.getAllTasksByStatus(status);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Status",allStatus),HttpStatus.OK
        );
    }


    @GetMapping(path = "/get-by-employee/{employee}")
    public ResponseEntity<StandardResponse> getAllTasksByEmployee(
            @PathVariable(value = "employee") String employee){
        List<ResponseTaskDto> allMembers = taskService.getAllTasksByEmployee(employee);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Members",allMembers),HttpStatus.OK
        );
    }


}