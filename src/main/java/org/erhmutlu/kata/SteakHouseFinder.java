package org.erhmutlu.kata;

import java.util.*;
import java.util.stream.Collectors;

public class SteakHouseFinder {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                                   List<List<Integer>> allLocations,
                                                   int numSteakhouses) {

        Map<Integer, List<Integer>> distancesMap = new HashMap<>();
        allLocations.stream()
                .forEach(location -> {
                    Integer key = calculateSquareOfDistance(location.get(0), location.get(1));
                    distancesMap.put(key, location);
                });

        System.out.println(distancesMap);

        List<Integer> sortedDistances = distancesMap.keySet().stream().sorted().collect(Collectors.toList());
        System.out.println("sortedDistances: " + sortedDistances);
        List<List<Integer>> result = new LinkedList<>();
        System.out.println("x: " + numSteakhouses);
        for (int i = 0; i < numSteakhouses; i++) {
            System.out.println("i: " + i);
            Integer distance = sortedDistances.get(i);
            System.out.println("dis: " + distance);
            List<Integer> loc = distancesMap.get(distance);
            result.add(loc);
        }
        System.out.println("result: " + result);
        return result;
    }

    private static Integer calculateSquareOfDistance(Integer x, Integer y) {
        return new Double(Math.pow(x, 2) + Math.pow(y, 2)).intValue();
    }
}
