package com.woodwing.distancecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Response body for sum distance API
 */
@Getter
@Setter
@AllArgsConstructor
public class SumDistanceResponse {
    private float totalDistance;
    private String distanceUnit;
}
