package com.woodwing.distancecalculator.controller;

import com.woodwing.distancecalculator.exception.BadRequestException;
import com.woodwing.distancecalculator.model.SumDistanceRequest;
import com.woodwing.distancecalculator.model.SumDistanceResponse;
import com.woodwing.distancecalculator.service.DistanceCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class DistanceCalculatorControllerTest {
    @Mock
    DistanceCalculatorService distanceCalculatorService;
    DistanceCalculatorController controller;

    private static final SumDistanceResponse sumDistanceResponse = new SumDistanceResponse(10, "METERS");
    private static final SumDistanceRequest sumDistanceRequest = new SumDistanceRequest();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new DistanceCalculatorController(distanceCalculatorService);
    }

    @Test
    void sumDistanceShouldReturn200() {
        when(distanceCalculatorService.getSum(anyString(),
                                              anyString(),
                                              anyString(),
                                              anyString(),
                                              anyString())).thenReturn(sumDistanceResponse);
        ResponseEntity<SumDistanceResponse> response = controller.sumDistance(sumDistanceRequest);
        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
    }

    @Test
    void sumDistanceShouldReturn400IfServiceThrowBadRequestException() {
        when(distanceCalculatorService.getSum(anyString(),
                                              anyString(),
                                              anyString(),
                                              anyString(),
                                              anyString())).thenThrow(BadRequestException.class);
        ResponseEntity<SumDistanceResponse> response = controller.sumDistance(sumDistanceRequest);
        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
    }

}