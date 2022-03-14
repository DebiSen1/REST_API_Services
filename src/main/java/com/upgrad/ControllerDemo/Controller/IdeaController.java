package com.upgrad.ControllerDemo.Controller;

import com.upgrad.ControllerDemo.dto.IdeaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/demo_app/v1"})
public class IdeaController {

    //this map will work as an in-memory data storage for ideas.
    public static final Map<Integer,IdeaDTO> IDEA_MAP = new HashMap<Integer, IdeaDTO>();

    public IdeaController(){
        //create some ideas
        IdeaDTO ideaDTO1 = new IdeaDTO(1,"Good Idea","This is a good idea","Debi Sen");
        IdeaDTO ideaDTO2 = new IdeaDTO(2,"Neutral Idea","This is a neutral","Debarati Biswas");
        IdeaDTO ideaDTO3 = new IdeaDTO(3,"Bad Idea","This is a bad idea","Debarati Biswas");

        //store these ideas
        IDEA_MAP.put(ideaDTO1.getId(),ideaDTO1);
        IDEA_MAP.put(ideaDTO2.getId(),ideaDTO2);
        IDEA_MAP.put(ideaDTO3.getId(),ideaDTO3);
    }

    //I want to search an idea based on its id
    //pathVariable will map the ideaid from URI to id variable of method parameter
    @GetMapping(value = "/ideas/{ideaid}")
    public ResponseEntity getIdeaBasedOnId(@PathVariable(name = "ideaid") int id){
        return new ResponseEntity(IDEA_MAP.get(id), HttpStatus.OK);
    }

    //crate an IdeaDTO object

    @PostMapping(value = "/ideas/createIdea", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createIdea(@RequestBody IdeaDTO ideaDTO){
        IDEA_MAP.put(ideaDTO.getId(),ideaDTO);
        return new ResponseEntity(IDEA_MAP.get(ideaDTO.getId()),HttpStatus.CREATED);
    }


    //list of ideas

    @GetMapping(value = "/ideas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllIdeas(){
       
        List<IdeaDTO> ideas = new LinkedList<>();

        for(IdeaDTO ideaDTO : IDEA_MAP.values()){
            ideas.add(ideaDTO);
        }

        return new ResponseEntity(ideas,HttpStatus.OK);
    }


    //update a new idea

    @PutMapping(value = "/updateIdea/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateIdea(@PathVariable(name = "id") int id,@RequestBody IdeaDTO ideaDTO){

        IDEA_MAP.put(id, ideaDTO);

        return new ResponseEntity(ideaDTO,HttpStatus.ACCEPTED);
    }


    //delete an idea

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") int id){
        IDEA_MAP.remove(id);

        return new ResponseEntity(null,HttpStatus.OK);
    }

}
