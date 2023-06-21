package com.interview;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {

    @DataProvider(name = "simpleDataProvider")
    public Object[][] arrays() {

        return new Object[][]{
                {new Integer[]{4, 10, 2, 7, 20}, 2, 4},
                {new Integer[0], null, null},
                {new Integer[]{1}, 1, null},
                {new Integer[]{7, 6, 4, -3}, -3, 4},
                {new Integer[]{7, 6}, 6, 7},
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void checkForFindingTwoMinimumElementsInTheArray(Integer[] arr, Integer expected1, Integer expected2) {
        Main main = new Main();
        Integer[] twoMinElements = main.findTwoMinElements(arr);
        Assert.assertTrue(twoMinElements[0] == expected1);
        Assert.assertTrue(twoMinElements[1] == expected2);
    }

    @DataProvider(name = "dataProviderWithSort")
    public Object[][] arrayLists() {

        return new Object[][]{
                {List.of(4.0, 0.4, 4.5, 7.0, 7.0), List.of(0.4, 4.0)},
                {List.of(), List.of()},
                {List.of(1.0), List.of(1.0)},
                {List.of(0.1, 0.6, 1.4, -3.2), List.of(-3.2, 0.1)},
                {List.of(7.0, 6.0), List.of(6.0, 7.0)},
        };
    }

    @Test(dataProvider = "dataProviderWithSort")
    public void checkForFindingTwoMinimumElementsInTheArrayWithSort(List<Double> arr, List expected) {
        Main<Double> main = new Main();
        List<Double> twoMinElements = main.findTwoMinElementsWithSort(arr);
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertTrue(twoMinElements.get(i).equals(expected.get(i)));
        }
    }
}
