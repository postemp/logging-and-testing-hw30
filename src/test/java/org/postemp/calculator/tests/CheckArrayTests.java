package org.postemp.calculator.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.postemp.WorkingWithArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckArrayTests {
    WorkingWithArrays workingWithArrays;
    @BeforeEach
    public void init(){
        workingWithArrays = new WorkingWithArrays();
    }

    @Test
    public void hasRightReturnTest() {
        Assertions.assertTrue(workingWithArrays.checkArray(new int[]{2, 2, 1, 2, 2}));
    }

    public static Stream<Arguments> addArrayTrueTestData() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{2, 2, 1, 2, 2}));
        out.add(Arguments.arguments(new int[]{2, 1}));
        out.add(Arguments.arguments(new int[]{1, 2}));
        return out.stream();
    }

    @MethodSource("addArrayTrueTestData")
    @ParameterizedTest
    public void hasRightArrayTests(int[] inArr) {
        Assertions.assertTrue(workingWithArrays.checkArray(inArr));
    }


    public static Stream<Arguments> addArrayFalseTestData() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{}));
        out.add(Arguments.arguments(new int[]{1, 1,1}));
        out.add(Arguments.arguments(new int[]{ 2, 2, 4, 1} ));
        return out.stream();
    }

    @MethodSource("addArrayFalseTestData")
    @ParameterizedTest
    public void hasFalseArrayTests(int[] inArr) {
        Assertions.assertFalse(workingWithArrays.checkArray(inArr));
    }
}
