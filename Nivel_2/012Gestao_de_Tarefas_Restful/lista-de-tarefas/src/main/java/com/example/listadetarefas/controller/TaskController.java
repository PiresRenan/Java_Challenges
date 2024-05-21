package com.example.listadetarefas.controller;

import com.example.listadetarefas.model.Task;
import com.example.listadetarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") Task task) {
        task.setCreatedAt(new Date());
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa inválida: " + id));
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable("id") long id, @ModelAttribute("task") Task task,
                             Model model) {
        task.setCreatedAt(new Date());
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") long id, Model model) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa inválida: " + id));
        taskRepository.delete(task);
        return "redirect:/";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
