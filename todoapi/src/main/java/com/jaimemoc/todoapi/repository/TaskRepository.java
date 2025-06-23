package com.jaimemoc.todoapi.repository;

import com.jaimemoc.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface TaskRepository extends JpaRepository<Task, Long> {
}