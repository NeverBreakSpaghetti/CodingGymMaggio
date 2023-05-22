import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int cookies(int sweetness, List<Integer> input){
        PriorityQueue<Integer> cookieQueue = new PriorityQueue<>(input);
        int iterations = 0;

        while (existCookieBelowSweetness(sweetness, cookieQueue) && cookieQueue.size()>1){
            mix2Cookies(cookieQueue);
            iterations++;
        }

        if (existCookieBelowSweetness(sweetness, cookieQueue))
            return -1;

        return iterations;
    }

    private static boolean existCookieBelowSweetness(int sweetness, PriorityQueue<Integer> cookieQueue) {
        return cookieQueue.peek() < sweetness;
    }

    private static void mix2Cookies(PriorityQueue<Integer> cookiesQueue) {
        int leastSweetCookie = cookiesQueue.poll();
        int secondLeastSweetCookie = cookiesQueue.poll();

        int mixedCookie = leastSweetCookie + 2*secondLeastSweetCookie;

        cookiesQueue.add(mixedCookie);
    }

//    public static int cookies(int sweetness, List<Integer> input) {
//        List<Integer> cookieArrayList = new ArrayList<>(input); // used to have the implementation of remove(int index)
//        int iterations = 0;
//        Collections.sort(cookieArrayList);
//
//        while (existCookieBelowSweetness(sweetness, cookieArrayList) && cookieArrayList.size()>1){
//            mix2Cookies(cookieArrayList);
//            iterations++;
//        }
//
//        if (cookieArrayList.get(0)<sweetness)
//            return -1;
//
//        return iterations;
//    }
//
//    private static boolean existCookieBelowSweetness(int sweetness, List<Integer> cookieList) {
//        return cookieList.get(0) < sweetness;
//    }
//
//    private static void mix2Cookies(List<Integer> cookiesList) {
//        int leastSweetCookie = cookiesList.remove(0);
//        int secondLeastSweetCookie = cookiesList.remove(0);
//
//        int mixedCookie = leastSweetCookie + 2*secondLeastSweetCookie;
//
//        insertNewCookieInTheRightPosition(cookiesList, mixedCookie);
//    }
//
//    private static void insertNewCookieInTheRightPosition(List<Integer> cookiesList, int cookie) {
//        int rightPosition = Collections.binarySearch(cookiesList, cookie);
//
//        if (rightPosition<0) {
//            rightPosition *= -1;
//            rightPosition -= 1;
//        }
//
//        cookiesList.add(rightPosition,cookie);
//    }
}
