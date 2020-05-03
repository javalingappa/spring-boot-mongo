package com.my.mongo.services.controller;


import com.my.mongo.services.services.DocumentQueryBasedImpl;
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
@Api(value = "API for My Mongo Services")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class DocumentQueryBasedController {
    @Autowired
    DocumentQueryBasedImpl documentQueryBasedService;

    @GetMapping("/document/query/create")
    @ApiOperation(value = "Generate and fetch consolidated agent claim details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Able to Generate and fetch consolidated agent claim details Successfully", response = List.class)})
    public ResponseEntity<?> fetchDocumentQueryBasedServiceDetails(@RequestParam("isFirst") boolean isFirst) throws Exception {
        return new ResponseEntity(documentQueryBasedService.generateAndFetchList(isFirst), HttpStatus.OK);
    }

}
