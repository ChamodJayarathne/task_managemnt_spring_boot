package com.chamod.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chamod.taskmanager.entity.Task;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(String status);
    List<Task> findAllByEmployee(String employee);


}