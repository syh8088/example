package com.example.api.controller;

import com.example.api.model.request.DeserializerTestRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deserializer")
@Api(tags = "Deserializer")
public class JsonDeserializeTest {
    @PostMapping
    @ApiOperation(value = "Deserializer test", notes = "Deserializer and returns the entity.")
    public ResponseEntity<List<String>> postDeserializerTest (
            @RequestBody @ApiParam(value = "Name") DeserializerTestRequest request) {
        List<String> response = request.getNames();
        return ResponseEntity.ok(response);
    }
}
