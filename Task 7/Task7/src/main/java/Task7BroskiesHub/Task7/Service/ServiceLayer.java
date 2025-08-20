package Task7BroskiesHub.Task7.Service;
import Task7BroskiesHub.Task7.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceLayer {


//    @Autowired
//    private Task taskObject;

    public List<Task> tasksData = new ArrayList<>(Arrays.asList(

            new Task(101, "Hello world", "Starting line of every programmer."),
            new Task(102, "i'll try again", "When code fails.")
            ));


    public List<Task> getData(){

        return tasksData;
    }
}
