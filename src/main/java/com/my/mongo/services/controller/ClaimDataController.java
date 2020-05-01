package com.my.mongo.services.controller;

import com.my.mongo.services.entity.Agent;
import com.my.mongo.services.repository.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Javalingappa
 */

@RestController
@Api(value = "API for My Mongo Services CRUD examples")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class ClaimDataController {

    @Autowired
    AgentRepository agentRepository;

    @GetMapping("/agent/list")
    @ApiOperation(value = "Fetch all  agent  details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able fetch list of agent  details Successfully", response = List.class)})
    public ResponseEntity<List<Agent>> fetchAgentList() throws Exception {
        return new ResponseEntity<>(agentRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/agent")
    @ApiOperation(value = "Create  agent claim details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Create and fetch agent Successfully", response = Agent.class)})
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) throws Exception {
        return new ResponseEntity<>(agentRepository.save(agent), HttpStatus.CREATED);
    }

    @PutMapping("/agent")
    @ApiOperation(value = "Update agent claim details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Update and fetch agent Successfully", response = Agent.class)})
    public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) throws Exception {
        return new ResponseEntity<>(agentRepository.save(agent), HttpStatus.OK);
    }

    @DeleteMapping("/agent/{id}")
    @ApiOperation(value = "Delete agent claim details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Delete agent Successfully", response = Object.class)})
    public ResponseEntity<?> DeleteAgent(@PathVariable("id") String id) throws Exception {
        agentRepository.deleteById(id);
        return new ResponseEntity<>("{\"message\": \"deleted successfully\",\"status\": 200}", HttpStatus.OK);
    }
}
