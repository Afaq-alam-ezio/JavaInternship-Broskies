package com.Task8ByBroSkiesHub.Task8.ServiceLayer;

import com.Task8ByBroSkiesHub.Task8.Model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceLayer {


    private int manualId = 1;

    private List<Tasks> task = new ArrayList<>(Arrays.asList(

            new Tasks(101, "Wake up", "Wake at correct time."),
            new Tasks(102, "Code", "Now once woken up, let's code.")
    ));


//    Below returns all Tasks data
    public List<Tasks> getAllTasksData() {

        return task;
    }


//    Below adds new tasks via form on frontend
    public void addNewTask(Tasks formData) {

        task.add(new Tasks(manualId++, formData.getTitle(), formData.getDescription()));
    }
}
