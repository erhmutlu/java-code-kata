package org.erhmutlu.kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DistanceCalculator {

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(1, 0, 0));
        list.add(Arrays.asList(1, 0, 0));
        list.add(Arrays.asList(1, 9, 1));

//        int dis = calculateDistance(3, 3, list);
//        System.out.println(dis);

        list = new LinkedList<>();
        list.add(Arrays.asList(1, 1, 1, 1));
        list.add(Arrays.asList(0, 1, 1, 1));
        list.add(Arrays.asList(0, 1, 0, 1));
        list.add(Arrays.asList(1, 1, 9, 1));
        list.add(Arrays.asList(0, 0, 1, 1));


        int dis = calculateDistance(5, 4, list);
        System.out.println(dis);

    }

    static int calculateDistance(int numRows, int numColumns, List<List<Integer>> lot) {
        // WRITE YOUR CODE HERE
        int startX = 0, startY = 0;
        return goTo(numRows, numColumns, startX, startY, lot, 0, new LinkedList<>());
    }

    private static int goTo(int numRows, int numColumns, int x, int y, List<List<Integer>> lot, int distance, List<Location> visitedLocations) {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        if (isLeaveLot(numRows, numColumns, x, y)) {
            return -99;
        } else if (isTrenche(x, y, lot)) {
            return -99;
        } else if (isObstacle(x, y, lot)) {
            return distance;
        } else {
            visitedLocations.add(new Location(x, y));
            //goLeft
            if (x - 1 > 0 && isNotVisited(x - 1, y, visitedLocations)) {
                System.out.println("left: " + (x - 1));
                int value = goTo(numRows, numColumns, x - 1, y, lot, distance + 1, visitedLocations);
                if (value > 0) {
                    return value;
                }
            }

            //goRight
            if (x + 1 < numRows && isNotVisited(x + 1, y, visitedLocations)) {
                System.out.println("right: " + (x + 1));
                int value = goTo(numRows, numColumns, x + 1, y, lot, distance + 1, visitedLocations);
                if (value > 0) {
                    return value;
                }
            }

            //goUp
            if (y + 1 < numColumns && isNotVisited(x, y + 1, visitedLocations)) {
                System.out.println("up: " + (y + 1));
                int value = goTo(numRows, numColumns, x, y + 1, lot, distance + 1, visitedLocations);
                if (value > 0) {
                    return value;
                }
            }

            //goDown
            if (y - 1 > 0 && isNotVisited(x, y - 1, visitedLocations)) {
                System.out.println("down: " + (y - 1));
                int value = goTo(numRows, numColumns, x, y - 1, lot, distance + 1, visitedLocations);
                if (value > 0) {
                    return value;
                }
            }
        }
        return 1;
    }

    private static boolean isLeaveLot(int numRows, int numColumns, int x, int y) {
        return !(x < numRows && y < numColumns);
    }

    private static boolean isTrenche(int x, int y, List<List<Integer>> lot) {
        return lot.get(x).get(y) == 0;
    }

    private static boolean isObstacle(int x, int y, List<List<Integer>> lot) {
        return lot.get(x).get(y) == 9;
    }

    private static boolean isNotVisited(int x, int y, List<Location> visitedLocations) {
        return !visitedLocations.stream().anyMatch(location -> location.getX() == x && location.getY() == y);
    }

    static class Location {
        private int X, Y;

        public Location(int x, int y) {
            X = x;
            Y = y;
        }

        public int getX() {
            return X;
        }

        public void setX(int x) {
            X = x;
        }

        public int getY() {
            return Y;
        }

        public void setY(int y) {
            Y = y;
        }
    }
}

