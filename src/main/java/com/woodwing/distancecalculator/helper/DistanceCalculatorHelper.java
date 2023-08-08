package com.woodwing.distancecalculator.helper;

import com.woodwing.distancecalculator.model.DistanceUnit;

public class DistanceCalculatorHelper {
    private DistanceCalculatorHelper() {
        throw new IllegalStateException("Utility class");
    }
    private static final float METER_YARD_CONVERSION_FACTORS = 1.093613298F;

    /**
     * Convert distance into targeted unit
     *
     * @param distance     distance
     * @param distanceUnit unit of the distance
     * @param targetUnit   target unit of the conversion
     *
     * @return converted distance in float
     */
    public static float convertDistance(float distance, String distanceUnit, String targetUnit) {
        if(!distanceUnit.equalsIgnoreCase(targetUnit)){
            if(distanceUnit.equalsIgnoreCase(DistanceUnit.METERS.toString())){
                return distance * METER_YARD_CONVERSION_FACTORS;
            }
            if(distanceUnit.equalsIgnoreCase(DistanceUnit.YARDS.toString())){
                return distance / METER_YARD_CONVERSION_FACTORS;
            }
        }
        return distance;
    }
}
