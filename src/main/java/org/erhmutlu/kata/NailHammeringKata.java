package org.erhmutlu.kata;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NailHammeringKata {

    public int solution(int[] nailSizes, int maxHammeringCount) {
        Map<Integer, Integer> lengthAndCountMapping = prepareLengthAndCountMapping(nailSizes);
        List<NailLengthAndCount> nailLengthAndCountsByLengthDesc = sortedByLengthDesc(lengthAndCountMapping);

        int longerNailsCount = 0;
        int result = -1;
        for (NailLengthAndCount nailLengthAndCount : nailLengthAndCountsByLengthDesc) {
            int longerSelectableNailsCount = Math.min(maxHammeringCount, longerNailsCount);

            int newPossibleCountWithCurrentLength = nailLengthAndCount.getCount() + longerSelectableNailsCount;
            result = Math.max(result, newPossibleCountWithCurrentLength);

            longerNailsCount += nailLengthAndCount.getCount();
        }

        return result;
    }

    private Map<Integer, Integer> prepareLengthAndCountMapping(int[] nailSizes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int nailSize : nailSizes) {
            Integer count = map.getOrDefault(nailSize, 0);
            map.put(nailSize, ++count);
        }
        return map;
    }

    private List<NailLengthAndCount> sortedByLengthDesc(Map<Integer, Integer> mappedByLength) {
        Comparator<NailLengthAndCount> lengthComparatorDesc = Comparator.comparing(NailLengthAndCount::getLength).reversed();
        return mappedByLength.entrySet()
                .stream()
                .map(entry -> new NailLengthAndCount(entry.getKey(), entry.getValue()))
                .sorted(lengthComparatorDesc)
                .collect(Collectors.toList());
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
