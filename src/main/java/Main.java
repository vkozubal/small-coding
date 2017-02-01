import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    /*
     * What algorithm to chose depends on the actual values n and k
     * if k is huge don't use the algorithm with k as the exponent (n^(k-1))
     * if n is huge and k is small don't user the algorithm with the power of n O(n! / (n-k)!)
     *
     *
     * More efficient algorithms exists. But has more sophisticated means which sort an array first or
     * based on previously computed values. But it requires more time to find solution for this problem )).
     */

    /**
     * Brut-force running time for the solutions is n^k
     * Above presented solutions with less computation time
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/resources", "samples-1");

        //The stream hence file will also be closed here
        try (Stream<String> lines = Files.lines(path)) {
            List<Integer> ints = lines.mapToInt(Integer::valueOf)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            Integer k = ints.get(0);
            Integer sum = ints.get(1);
            List<Integer> intLst = ints.subList(2, ints.size());

            ints.forEach((Integer x) -> {
                System.out.print(x + " ");
            });
            System.out.println();

            System.out.println("-----------------------------");
            afg1(k, sum, intLst);

            System.out.println("-----------------------------");
            alg2(k, sum, intLst);
        }
    }

    /**
     * Running time of the algorithm is n^(k-1)
     *
     * @param k      number of elements to be summed
     * @param sum    expected sum of elements from sample
     * @param intLst collection of ints
     */
    private static void alg2(Integer k, Integer sum, List<Integer> intLst) {

        printArguments(k, sum);

        // use hashtable for constant time element access
        Set<Integer> intSet = new HashSet<>();
        intSet.addAll(intLst);

        List<Integer> result = new ArrayList<>();
        boolean solutionExists = findElement(intSet, k, sum, result);

        printSolutions(result, solutionExists);
    }

    private static boolean findElement(Set<Integer> ints, Integer k, Integer sum, List<Integer> result) {
        if (k < 0) return false;
        if (k == 1) {
            if (ints.contains(sum)) { // constant time element access
                result.add(sum);
                return true;
            }
            return false;
        } else {
            for (Integer i : ints) {
                HashSet<Integer> set = new HashSet<>(ints);
                set.remove(i);

                if (findElement(set, k - 1, sum - i, result)) {
                    return result.add(i);
                }
            }
        }
        return false;
    }


    /**
     * Running time of this solution is a little bit more efficient than brute force
     * It is k permutations of n (sequence without repetition) and it takes O(n * (n-1) * .. * (n - k + 1))
     * the same O(n! / (n-k)!)
     *
     * @param k number of elements to be summed
     * @param sum expected sum of elements from sample
     * @param intLst collection of ints
     */
    private static void afg1(Integer k, Integer sum, List<Integer> intLst) {

        printArguments(k, sum);

        List<Integer> result = new ArrayList<>();
        boolean isFound = findSolutions(intLst, sum, k - 1, result);

        printSolutions(result, isFound);
    }

    private static void printSolutions(List<Integer> result, boolean isFound) {
        if (isFound) {
            System.out.println("result was found:  ");
            result.forEach(System.out::println);
        } else System.out.println("solution doesn't exist");
    }

    private static boolean findSolutions(List<Integer> ints, Integer sum, Integer k, List<Integer> res) {
        for (int i = 0; i < ints.size(); i++) {
            if (k < 0) return false;
            if ((k == 0) && Objects.equals(ints.get(i), sum)) {
                return res.add(ints.get(i));
            } else {
                if (findSolutions(ints.subList(i + 1, ints.size()), sum - ints.get(i), k - 1, res)) {
                    return res.add(ints.get(i));
                }
            }
        }
        return false;
    }

    private static void printArguments(Integer k, Integer sum) {
        System.out.println("number of distinct integers: (k)" + k);
        System.out.println("sum should be equal to: (sum)" + sum);
    }
}