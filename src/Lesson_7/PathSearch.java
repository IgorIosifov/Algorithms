package Lesson_7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathSearch {


    private static void graphFilling(Graph graph) {

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");
        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");
        }

    private static void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graphFilling(graph);
        Stack<String> path = graph.searchShortestPath("Москва", "Воронеж");
        System.out.println("\n The shortest path:");
        showShortPath(path);

    }
}
