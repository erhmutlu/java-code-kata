package org.erhmutlu.kata;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

public class NailHammeringKata {

    public int solution(int[] nailSizes, int maxHammeringCount) {
        Map<Integer, List<Integer>> mappedByLength = Arrays.stream(nailSizes)
                .boxed()
                .collect(groupingBy(Function.identity()));

        TreeSet<NailLengthAndCount> treeSetByCount = prepareTreeSetByCountDesc(mappedByLength);
        TreeSet<NailLengthAndCount> treeSetByLength = prepareTreeSetByLengthDesc(mappedByLength);

        int result = -1;
        for (NailLengthAndCount nailLengthAndCount : treeSetByCount) {
            SortedSet<NailLengthAndCount> longerNailsLengthAndCounts = treeSetByLength.headSet(nailLengthAndCount);
            int hammeringCount = 0;

            for (NailLengthAndCount longerNailsLengthAndCount : longerNailsLengthAndCounts) {
                int remainingPossibleHammeringCount = maxHammeringCount - hammeringCount;
                if (remainingPossibleHammeringCount == 0) {
                    break;
                }
                int cnt = Math.min(longerNailsLengthAndCount.getCount(), remainingPossibleHammeringCount);
                hammeringCount += cnt;
            }

            result = Math.max(result, hammeringCount + nailLengthAndCount.getCount());
        }

        return result;
    }

    private TreeSet<NailLengthAndCount> prepareTreeSetByCountDesc(Map<Integer, List<Integer>> mappedByLength) {
        Comparator<NailLengthAndCount> countComparatorDesc = Comparator.comparing(NailLengthAndCount::getCount).reversed();
        return prepareTreeSet(mappedByLength, countComparatorDesc);
    }

    private TreeSet<NailLengthAndCount> prepareTreeSetByLengthDesc(Map<Integer, List<Integer>> mappedByLength) {
        Comparator<NailLengthAndCount> lengthComparatorDesc = Comparator.comparing(NailLengthAndCount::getLength).reversed();
        return prepareTreeSet(mappedByLength, lengthComparatorDesc);
    }

    private TreeSet<NailLengthAndCount> prepareTreeSet(Map<Integer, List<Integer>> mappedByLength, Comparator<NailLengthAndCount> comparator) {
        TreeSet<NailLengthAndCount> treeSet = new TreeSet<>(comparator);
        mappedByLength.entrySet()
                .stream()
                .map(entry -> new NailLengthAndCount(entry.getKey(), entry.getValue().size()))
                .forEach(treeSet::add);

        return treeSet;
    }

    static class NailLengthAndCount {
        private final Integer length;
        private final Integer count;

        public NailLengthAndCount(Integer length, Integer count) {
            this.length = length;
            this.count = count;
        }

        public Integer getLength() {
            return length;
        }

        public Integer getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        NailHammeringKata nailHammeringKata = new NailHammeringKata();
        int result = nailHammeringKata.solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 7);//9
        System.out.println(result);
    }

}
