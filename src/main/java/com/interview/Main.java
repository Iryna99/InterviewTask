package com.interview;
import java.util.List;
import java.util.stream.Collectors;

public class Main<T extends Number> {
    public Integer[] findTwoMinElements(Integer[] arrayInt) {
        if (arrayInt.length == 0) {
            return new Integer[]{null, null};
        }
        if (arrayInt.length == 1) {
            return new Integer[]{arrayInt[0], null};
        }
        int min = Integer.MAX_VALUE;
        for (int elem : arrayInt) {
            if (elem < min) {
                min = elem;
            }
        }

        int min2 = arrayInt[0];
        for (int elem2 : arrayInt) {
            if (min2 > elem2) {
                if (elem2 != min) {
                    min2 = elem2;
                }
            }
        }

        return new Integer[]{min, min2};
    }

    public List<T> findTwoMinElementsWithSort(List<T> arrayList) {
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        if (arrayList.size() == 1) {
            return List.of(arrayList.get(0));
        }

        List<T> sortedList = arrayList.stream()
                .sorted()
                .collect(Collectors.toList())
                .subList(0, 2);

        return sortedList;
    }
}
