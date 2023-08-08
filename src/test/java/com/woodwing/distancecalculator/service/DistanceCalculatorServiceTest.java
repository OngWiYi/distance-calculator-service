package com.woodwing.distancecalculator.service;

import com.woodwing.distancecalculator.exception.BadRequestException;
import com.woodwing.distancecalculator.model.SumDistanceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DistanceCalculatorServiceTest {

    private DistanceCalculatorService service;

    private static final String someDistance = "3";
    private static final String someUnit = "Yards";

    @BeforeEach
    void setUp() {
        this.service = new DistanceCalculatorService();
    }

    @Test
    void getSumShouldReturnCorrectValue() {
        SumDistanceResponse response = service.getSum("3", "yards", "5", "meters", "meters");
        Assertions.assertEquals(7.7432003F, response.getTotalDistance());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidParameter")
    void getSumShouldThrowBadRequestException(String firstDistance, String firstDistanceUnit, String secondDistance,
                                              String secondDistanceUnit, String responseUnit) {
        Assertions.assertThrows(BadRequestException.class,
                                () -> service.getSum(firstDistance,
                                                     firstDistanceUnit,
                                                     secondDistance,
                                                     secondDistanceUnit,
                                                     responseUnit));
    }

    private static Stream<Arguments> provideInvalidParameter() {
        return Stream.of(
                Arguments.of(null, someUnit, someDistance, someUnit, someUnit),
                Arguments.of("", someUnit, someDistance, someUnit, someUnit),
                Arguments.of("invalidDistance", someUnit, someDistance, someUnit, someUnit),
                Arguments.of(someDistance, null, someDistance, someUnit, someUnit),
                Arguments.of(someDistance, "", someDistance, someUnit, someUnit),
                Arguments.of(someDistance, "invalidUnit", someDistance, someUnit, someUnit),
                Arguments.of(someDistance, someUnit, null, someUnit, someUnit),
                Arguments.of(someDistance, someUnit, "", someUnit, someUnit),
                Arguments.of(someDistance, someUnit, "invalidDistance", someUnit, someUnit),
                Arguments.of(someDistance, someUnit, someDistance, null, someUnit),
                Arguments.of(someDistance, someUnit, someDistance, "", someUnit),
                Arguments.of(someDistance, someUnit, someDistance, "invalidUnit", someUnit),
                Arguments.of(someDistance, someUnit, someDistance, someUnit, null),
                Arguments.of(someDistance, someUnit, someDistance, someUnit, ""),
                Arguments.of(someDistance, someUnit, someDistance, someUnit, "invalidUnit")
        );
    }


}