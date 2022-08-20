package resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @GetMapping("/test")
    public List<String> Test(){
        List<String> data = new ArrayList<>();
        for (int i =1; i <= 10; i++){
            data.add("Data " + i);
        }
        return data;
    }
}
