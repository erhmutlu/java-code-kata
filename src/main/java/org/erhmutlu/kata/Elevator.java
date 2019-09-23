package org.erhmutlu.kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elevator {

    private static int peopleCountSum = 0;
    private static int peopleWeightSum = 0;
    private static int stopsSum = 0;

    /*A = Weights array
    B = Target floor
    M = No of floors
    X = Max capacity
    Y = Max weight
    */
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        return solve(createPersonQueue(A, B), M, X, Y);
    }

    private Queue<Person> createPersonQueue(int[] A, int[] B) {
        return IntStream.rangeClosed(0, A.length - 1)
                .mapToObj(i -> new Person(A[i], B[i]))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private int solve(final Queue<Person> queue, int totalFloors, final int maxCountCapacity, final int maxWeightCapacity) {
        Iterator iterator = queue.iterator();
        Set<Integer> floorSet = new HashSet<>();
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            if (allowedToBeIn(person, maxCountCapacity, maxWeightCapacity)) {
                floorSet.add(person.getTargetFloor());
            } else {
                stopsSum += floorSet.size() + 1;
                floorSet = new HashSet<>();
                floorSet.add(person.getTargetFloor());
                peopleCountSum = 1;
                peopleWeightSum = person.getWeight();
            }
        }
        return stopsSum += floorSet.size() != 0 ? floorSet.size() + 1 : 0;
    }

    private boolean allowedToBeIn(final Person person, final int maxCountCapacity, final int maxWeightCapacity) {
        if (peopleCountSum + 1 > maxCountCapacity || peopleWeightSum + person.getWeight() > maxWeightCapacity) {
            return false;
        } else {
            peopleCountSum += 1;
            peopleWeightSum += person.getWeight();
            return true;
        }
    }

    private class Person {
        private int weight;
        private int targetFloor;

        public Person(int weight, int targetFloor) {
            this.weight = weight;
            this.targetFloor = targetFloor;
        }

        public int getWeight() {
            return weight;
        }

        public int getTargetFloor() {
            return targetFloor;
        }
    }

}
