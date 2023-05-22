import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    private static Stack<Integer> inputStack = new Stack<>();
    private static Stack<Integer> outputStack = new Stack<>();

    public static void executeQueries(String[] queries){
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt(); //consume unuseful info: number of queries

        while (scanner.hasNext()) {
            int queryType = scanner.nextInt();

            switch (queryType){
                case 1 -> {
                    int valueToEnqueue = scanner.nextInt();
                    enqueue(valueToEnqueue);
                }
                case 2 -> dequeue();
                case 3 -> print();
            }
        }
    }

    private static void enqueue(int valueToEnqueue) {
        inputStack.push(valueToEnqueue);
    }

    private static void dequeue() {
        if (outputStack.empty())
            reverseInputStackInOutputStack();
        outputStack.pop();
    }

    private static void reverseInputStackInOutputStack() {
        while (!inputStack.empty())
            outputStack.push(inputStack.pop());
    }

    private static void print() {
        if (outputStack.empty())
            reverseInputStackInOutputStack();
        System.out.println(outputStack.peek());
    }


//    private static Stack<Integer> stack = new Stack<>();
//    private static Stack<Integer> reverseStack = new Stack<>();
//
//    public static void executeQueries(String[] queries){
//        int previousQueryType = 0;
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt(); //consume unuseful info: number of queries
//
//        while (scanner.hasNext()) {
//            int queryType = scanner.nextInt();
//
//            switch (queryType){
//                case 1 -> {
//                    int valueToEnqueue = scanner.nextInt();
//                    enqueue(valueToEnqueue,previousQueryType);
//                }
//                case 2 -> dequeue(previousQueryType);
//                case 3 -> print(previousQueryType);
//            }
//            previousQueryType = queryType;
//        }
//    }
//
//    private static void enqueue(int valueToEnqueue, int previousQueryType) {
//        if(previousQueryType!=1 && previousQueryType!=0)
//            reverseReverseStack();
//        stack.push(valueToEnqueue);
//    }
//
//    private static void reverseStack() {
//        while (!stack.empty())
//            reverseStack.push(stack.pop());
//    }
//
//    private static void dequeue(int previousQueryType) {
//        if (previousQueryType!=2 && previousQueryType!=3)
//            reverseStack();
//        reverseStack.pop();
//    }
//
//    private static void reverseReverseStack() {
//        while (!reverseStack.empty())
//            stack.push(reverseStack.pop());
//    }
//
//    private static void print(int previousQueryType) {
//        if (previousQueryType!=2 && previousQueryType!=3)
//            reverseStack();
//        System.out.println(reverseStack.peek().toString());
//    }

}
