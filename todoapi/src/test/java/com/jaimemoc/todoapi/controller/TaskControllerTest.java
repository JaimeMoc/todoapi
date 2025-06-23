package com.jaimemoc.todoapi.controller;

import com.jaimemoc.todoapi.model.Task;
import com.jaimemoc.todoapi.repository.TaskRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() throws Exception {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Test task 1");
        task1.setDescription("Description 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Test task 2");
        task2.setDescription("Description 2");
        task2.setCompleted(true);

        // Mockeamos la respuesta del repo
        Mockito.when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Ejecutamos el request GET /tasks y validamos que regrese ok.
        mockMvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test task 1")))
                .andExpect(content().string(containsString("Test task 2")));
    }
}
