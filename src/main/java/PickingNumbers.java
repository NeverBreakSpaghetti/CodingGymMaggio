import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingNumbers {
    public static int result(List<Integer> input) {
        int[] frequency = createFrequencyList(input);
        return maxFrequencyWithMaxDistanceOf1(frequency);

//        Map<Integer,Integer> frequencyMap = createFrequencyMap(input);
//        return maxFrequencyWithMaxDistanceOf1(frequencyMap);
    }

    private static int[] createFrequencyList(List<Integer> input) {
        int[] frequencyArray = new int[100];
        for (int i = 0; i< input.size(); i++) {
            int inputValue = input.get(i);
            frequencyArray[inputValue] = ++frequencyArray[inputValue];
        }
        return frequencyArray;
    }

    private static int maxFrequencyWithMaxDistanceOf1(int[] frequency) {
        int maxFrequency = frequency[0];
        int nElements = frequency.length;
        for (int i = 1; i < nElements-1; i++) {
            if (frequency[i]==0)
                continue;
            int potentialMaxFrequency = frequency[i-1] + frequency[i];
            maxFrequency = Math.max(maxFrequency, potentialMaxFrequency);
        }
        return maxFrequency;
    }

    private static Map<Integer,Integer> createFrequencyMap(List<Integer> input) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (Integer valueInput : input) {
            Integer valueFrequency = 0;
            if( frequencyMap.containsKey(valueInput) )
                valueFrequency = frequencyMap.get(valueInput);
            frequencyMap.put(valueInput, ++valueFrequency);
        }
        return frequencyMap;
    }

    private static int maxFrequencyWithMaxDistanceOf1(Map<Integer,Integer> frequencyMap) {
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> frequencyEntry : frequencyMap.entrySet()) {
            Integer inputValue = frequencyEntry.getKey();
            Integer potentialMaxFrequency = frequencyEntry.getValue();

            if (frequencyMap.containsKey(inputValue - 1))
                potentialMaxFrequency += frequencyMap.get(inputValue - 1);

            maxFrequency = Math.max(maxFrequency, potentialMaxFrequency);
        }

        return maxFrequency;
    }
}
