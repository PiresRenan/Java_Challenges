package com.example.listadetarefas.repository;

import com.example.listadetarefas.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
