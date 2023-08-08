package com.woodwing.distancecalculator.service;

import com.woodwing.distancecalculator.exception.BadRequestException;
import com.woodwing.distancecalculator.helper.DistanceCalculatorHelper;
import com.woodwing.distancecalculator.model.DistanceModel;
import com.woodwing.distancecalculator.model.DistanceUnit;
import com.woodwing.distancecalculator.model.SumDistanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Distance Calculator Service
 */
@Service
public class DistanceCalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculatorService.class);

    private static final String RESPONSE_UNIT_INVALID_ERROR_MESSAGE = "Response distance unit only accepts Yards and " +
            "Meters";

    public SumDistanceResponse getSum(String firstDistance, String firstDistanceUnit, String secondDistance,
                                      String secondDistanceUnit, String responseUnit) {
        validateParams(firstDistance, firstDistanceUnit, secondDistance, secondDistanceUnit, responseUnit);
        DistanceModel distanceModel = convertsDistance(firstDistance, firstDistanceUnit, secondDistance,
                                                       secondDistanceUnit, responseUnit);
        return new SumDistanceResponse(distanceModel.getSum(),
                                       distanceModel.getDistanceUnit().toString());
    }

    private DistanceModel convertsDistance(String firstDistance, String firstDistanceUnit, String secondDistance,
                                           String secondDistanceUnit, String responseUnit) {
        try {
            float firstDist = DistanceCalculatorHelper.convertDistance(Float.parseFloat(firstDistance),
                                                                       firstDistanceUnit, responseUnit);
            float secondDist = DistanceCalculatorHelper.convertDistance(Float.parseFloat(secondDistance),
                                                                        secondDistanceUnit, responseUnit);
            return new DistanceModel(firstDist, secondDist, DistanceUnit.valueOf(responseUnit.toUpperCase()));
        } catch (NumberFormatException e) {
            LOGGER.error("Distance value is in invalid format.");
            throw new BadRequestException("Distance value is in invalid format.");
        } catch (IllegalArgumentException e) {
            LOGGER.error(RESPONSE_UNIT_INVALID_ERROR_MESSAGE);
            throw new BadRequestException(RESPONSE_UNIT_INVALID_ERROR_MESSAGE);
        }
    }

    private void validateParams(String firstDistance, String firstDistanceUnit, String secondDistance,
                                String secondDistanceUnit, String responseUnit) {
        if (!StringUtils.hasText(firstDistance)) {
            LOGGER.error("First distance is empty.");
            throw new BadRequestException("First distance is empty.");
        }
        if (!StringUtils.hasText(secondDistance)) {
            LOGGER.error("Second distance is empty.");
            throw new BadRequestException("Second distance is empty.");
        }
        if (!StringUtils.hasText(firstDistanceUnit)) {
            LOGGER.error("First distance unit is empty.");
            throw new BadRequestException("First distance unit is empty.");
        }
        if (!(firstDistanceUnit.equalsIgnoreCase(DistanceUnit.YARDS.toString()) ||
                firstDistanceUnit.equalsIgnoreCase(DistanceUnit.METERS.toString()))) {
            LOGGER.error("First distance unit only accepts Yards and Meters");
            throw new BadRequestException("First distance unit only accepts Yards and Meters");
        }
        if (!StringUtils.hasText(secondDistanceUnit)) {
            LOGGER.error("Second distance unit is empty.");
            throw new BadRequestException("Second distance unit is empty.");
        }
        if (!(secondDistanceUnit.equalsIgnoreCase(DistanceUnit.YARDS.toString()) ||
                secondDistanceUnit.equalsIgnoreCase(DistanceUnit.METERS.toString()))) {
            LOGGER.error("Second distance unit only accepts Yards and Meters");
            throw new BadRequestException("Second distance unit only accepts Yards and Meters");
        }
        if (!StringUtils.hasText(responseUnit)) {
            LOGGER.error("Response distance unit is empty.");
            throw new BadRequestException("Response distance unit is empty.");
        }
        if (!(responseUnit.equalsIgnoreCase(DistanceUnit.YARDS.toString()) ||
                responseUnit.equalsIgnoreCase(DistanceUnit.METERS.toString()))) {
            LOGGER.error(RESPONSE_UNIT_INVALID_ERROR_MESSAGE);
            throw new BadRequestException(RESPONSE_UNIT_INVALID_ERROR_MESSAGE);
        }
    }

}
