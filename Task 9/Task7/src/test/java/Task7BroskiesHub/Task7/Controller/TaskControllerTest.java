package Task7BroskiesHub.Task7.Controller;

import Task7BroskiesHub.Task7.Model.Task;
import Task7BroskiesHub.Task7.Service.ServiceLayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ServiceLayer serviceLayer;

    @Test
    void testGetData_ReturnsTasks() throws Exception {
        List<Task> mockTasks = Arrays.asList(
                new Task(101, "Hello world", "Starting line of every programmer."),
                new Task(102, "i'll try again", "When code fails.")
        );

        when(serviceLayer.getData()).thenReturn(mockTasks);

        mockMvc.perform(get("/getData")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(101))
                .andExpect(jsonPath("$[0].title").value("Hello world"))
                .andExpect(jsonPath("$[0].description").value("Starting line of every programmer."))
                .andExpect(jsonPath("$[1].id").value(102))
                .andExpect(jsonPath("$[1].title").value("i'll try again"))
                .andExpect(jsonPath("$[1].description").value("When code fails."));
    }

        @Test
    void testGetData_ServiceThrowsException_ReturnsNotFound() throws Exception {
        when(serviceLayer.getData()).thenThrow(new RuntimeException("Simulated error"));

        mockMvc.perform(get("/getData")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Error : Simulated error")));
    }
}
