package Task7BroskiesHub.Task7.Controller;

import Task7BroskiesHub.Task7.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController {


    @Autowired
    private ServiceLayer sp;


    @GetMapping("/getData")
    public ResponseEntity<?> getData(){

        try{

            return new ResponseEntity<>(sp.getData(), HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
