package com.my.mongo.services.controller;

import com.my.mongo.services.entity.Contact;
import com.my.mongo.services.entity.Insured;
import com.my.mongo.services.entity.LossDetail;
import com.my.mongo.services.entity.AgentDetail;
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

    @Autowired
    AgentaDetailRepository agentaDetailRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    InsuredRepository insuredRepository;

    @Autowired
    LossDetailRepository lossDetailRepository;


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

    @GetMapping("/agentdetail/list")
    @ApiOperation(value = "Fetch all  agentdetail  details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able fetch list of  agentdetail details Successfully", response = List.class)})
    public ResponseEntity<List<AgentDetail>> fetchAgentDetailList() throws Exception {
        return new ResponseEntity<>(agentaDetailRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/agentdetail")
    @ApiOperation(value = "Generate and fetch agentdetail details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Generate and fetch agentdetail details Successfully", response = AgentDetail.class)})
    public ResponseEntity<AgentDetail> createAgentDetail(@RequestBody AgentDetail agentDetail) throws Exception {
        return new ResponseEntity<>(agentaDetailRepository.save(agentDetail), HttpStatus.OK);
    }

    @GetMapping("/contact/list")
    @ApiOperation(value = "Fetch all  contact  details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to fetch list of contact details Successfully", response = List.class)})
    public ResponseEntity<List<Contact>> fetchContactList() throws Exception {
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/contact")
    @ApiOperation(value = "Generate and fetch contact details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Generate and fetch contact details Successfully", response = Contact.class)})
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws Exception {
        return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.OK);
    }

    @GetMapping("/insured/list")
    @ApiOperation(value = "Fetch all  insured  details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to fetch list of insured details Successfully", response = List.class)})
    public ResponseEntity<List<Insured>> fetchInsuredList() throws Exception {
        return new ResponseEntity<>(insuredRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/insured")
    @ApiOperation(value = "Generate and fetch insured details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Generate and fetch insured details Successfully", response = Insured.class)})
    public ResponseEntity<Insured> createContact(@RequestBody Insured insured) throws Exception {
        return new ResponseEntity<>(insuredRepository.save(insured), HttpStatus.OK);
    }

    @GetMapping("/lossdetail/list")
    @ApiOperation(value = "Fetch all  lossdetail  details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to fetch list of lossdetail details Successfully", response = List.class)})
    public ResponseEntity<List<LossDetail>> fetchLossDetailList() throws Exception {
        return new ResponseEntity<>(lossDetailRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/lossdetail")
    @ApiOperation(value = "Generate and fetch lossdetail details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Generate and fetch lossdetail details Successfully", response = LossDetail.class)})
    public ResponseEntity<LossDetail> createLossDetail(@RequestBody LossDetail insured) throws Exception {
        return new ResponseEntity<>(lossDetailRepository.save(insured), HttpStatus.OK);
    }


}
