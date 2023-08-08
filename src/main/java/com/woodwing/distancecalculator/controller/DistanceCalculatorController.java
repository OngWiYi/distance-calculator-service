package com.woodwing.distancecalculator.controller;

import com.woodwing.distancecalculator.model.SumDistanceRequest;
import com.woodwing.distancecalculator.model.SumDistanceResponse;
import com.woodwing.distancecalculator.service.DistanceCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Distance calculator controller
 */
@RestController
@RequestMapping("/distance")
@RequiredArgsConstructor
public class DistanceCalculatorController {
    @Autowired
    private final DistanceCalculatorService distanceCalculatorService;

    @PostMapping(path = "/sum")
    public ResponseEntity<SumDistanceResponse> sumDistance(
            @RequestBody
            SumDistanceRequest body) {
        return ResponseEntity.ok(distanceCalculatorService.getSum(body.getFirstDistance(),
                                                                  body.getFirstDistanceUnit(),
                                                                  body.getSecondDistance(),
                                                                  body.getSecondDistanceUnit(),
                                                                  body.getResponseUnit()));
    }


}
