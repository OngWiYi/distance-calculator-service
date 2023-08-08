package com.woodwing.distancecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Distance Model
 */
@Getter
@Setter
@AllArgsConstructor
public class DistanceModel {
    private float firstDistance;
    private float secondDistance;
    private DistanceUnit distanceUnit;

    public float getSum(){
        return firstDistance + secondDistance;
    }
}
