package com.Task8ByBroSkiesHub.Task8.ControllerLayer;

import com.Task8ByBroSkiesHub.Task8.Model.Tasks;
import com.Task8ByBroSkiesHub.Task8.ServiceLayer.ServiceLayer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class Controller {

    @Autowired
    private ServiceLayer serviceObject;

    @GetMapping("/getTasks")
    public ResponseEntity<?> getAllTasksData(){

        try{

            return new ResponseEntity<>(serviceObject.getAllTasksData(), HttpStatus.ACCEPTED);
        }
        catch(Exception e){

            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addNewTask")
    public ResponseEntity<?> addNewTask(@RequestBody Tasks formData){

        try{

            serviceObject.addNewTask(formData);
            return new ResponseEntity<>("New task added!", HttpStatus.ACCEPTED);
        }
        catch(Exception e){

            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
