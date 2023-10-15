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

public class ProcessArrayTests {
    WorkingWithArrays workingWithArrays;
    @BeforeEach
    public void init(){
        workingWithArrays = new WorkingWithArrays();
    }

    @Test
    public void hasRightArrayTest() {
        Assertions.assertArrayEquals(new int[]{2,2},workingWithArrays.processArray(new int[]{2, 2, 1, 2, 2}));
    }

    @Test
    public void doesntHave1ArrayTest() {
        Assertions.assertThrows(RuntimeException.class, ()->workingWithArrays.processArray(new int[]{ 2, 2}));
    }

    public static Stream<Arguments> addArrayTestData() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{2, 2, 1, 2, 2}, new int[]{2,2}));
        out.add(Arguments.arguments(new int[]{2, 2, 1, 1, 2}, new int[]{2}));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 2, 2}, new int[]{2, 2, 2, 2}));
        out.add(Arguments.arguments(new int[]{ 2, 2, 2, 1}, new int[]{}));
        return out.stream();
    }

    @MethodSource("addArrayTestData")
    @ParameterizedTest
    public void hasRightArrayTests(int[] inArr, int[] outArr) {
        Assertions.assertArrayEquals(outArr,workingWithArrays.processArray(inArr));
    }
}
