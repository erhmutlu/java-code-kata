package org.erhmutlu.kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathKata {

    private final static int LOCATION_WITH_ROAD = 1;
    private final static int LOCATION_WITHOUT_ROAD = 0;
    private final static int DESTINATION = 9;

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        List<Location> visitedLocations = new LinkedList<>();
        return visit(numRows, numColumns, area, 0, 0, visitedLocations);
    }

    private int visit(int numRows, int numColumns, List<List<Integer>> area, int row, int column, List<Location> visitedLocations) {
        Integer value = area.get(row).get(column);
        if (value == LOCATION_WITHOUT_ROAD) {
            return -1;
        }

        if (value == DESTINATION) {
            return 1;
        }

        visitedLocations.add(new Location(row, column));

        int smallestPath = 0;
        if (row + 1 < numRows) {
            Integer valueOfLocation = area.get(row + 1).get(column);
            if ((valueOfLocation == LOCATION_WITH_ROAD || valueOfLocation == DESTINATION) && !visitedLocations.contains(new Location(row + 1, column))) {
                int visits = visit(numRows, numColumns, area, row + 1, column, new LinkedList<>(visitedLocations));
                if (visits != -1 && smallestPath == 0) {
                    smallestPath = visits;
                } else {
                    smallestPath = Math.min(visits, smallestPath);
                }
            }
        }

        if (row - 1 > 0) {
            Integer valueOfLocation = area.get(row - 1).get(column);
            if ((valueOfLocation == LOCATION_WITH_ROAD || valueOfLocation == DESTINATION) && !visitedLocations.contains(new Location(row - 1, column))) {
                int visits = visit(numRows, numColumns, area, row - 1, column, new LinkedList<>(visitedLocations));
                if (visits != -1 && smallestPath == 0) {
                    smallestPath = visits;
                } else {
                    smallestPath = Math.min(visits, smallestPath);
                }
            }
        }

        if (column + 1 < numColumns) {
            Integer valueOfLocation = area.get(row).get(column + 1);
            if ((valueOfLocation == LOCATION_WITH_ROAD || valueOfLocation == DESTINATION) && !visitedLocations.contains(new Location(row, column + 1))) {
                int visits = visit(numRows, numColumns, area, row, column + 1, new LinkedList<>(visitedLocations));
                if (visits != -1 && smallestPath == 0) {
                    smallestPath = visits;
                } else {
                    smallestPath = Math.min(visits, smallestPath);
                }
            }
        }

        if (column - 1 > 0) {
            Integer valueOfLocation = area.get(row).get(column - 1);
            if ((valueOfLocation == LOCATION_WITH_ROAD || valueOfLocation == DESTINATION) && !visitedLocations.contains(new Location(row, column - 1))) {
                int visits = visit(numRows, numColumns, area, row, column - 1, new LinkedList<>(visitedLocations));
                if (visits != -1 && smallestPath == 0) {
                    smallestPath = visits;
                } else {
                    smallestPath = Math.min(visits, smallestPath);
                }
            }
        }

        if (row != 0 ||column != 0){
            smallestPath++;
        }
        return smallestPath;
    }


    class Location {
        private final int row;
        private final int column;

        public Location(int x, int y) {
            this.row = x;
            this.column = y;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Location) {
                Location that = (Location) obj;
                return that.getRow() == this.getRow() && that.getColumn() == this.getColumn();
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();

        lists.add(Arrays.asList(1, 0, 0));
        lists.add(Arrays.asList(1, 0, 0));
        lists.add(Arrays.asList(1, 9, 1));



//        List<List<Integer>> lists = new LinkedList<>();
//
//        lists.add(Arrays.asList(1, 1, 1, 1));
//        lists.add(Arrays.asList(0, 1, 1, 1));
//        lists.add(Arrays.asList(0, 1, 0, 1));
//        lists.add(Arrays.asList(1, 1, 9, 1));
//        lists.add(Arrays.asList(0, 0, 1, 1));

        ShortestPathKata shortestPathKata = new ShortestPathKata();
        System.out.println(shortestPathKata.minimumDistance(3, 3, lists));

    }

}
