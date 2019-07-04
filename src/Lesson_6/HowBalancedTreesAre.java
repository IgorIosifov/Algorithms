package Lesson_6;

import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Random;

public class HowBalancedTreesAre {

    public static ArrayList<TreeImpl<Integer>> creatingRandomTrees(int amountTrees) {
        ArrayList<TreeImpl<Integer>> forest = new ArrayList<>();
        for (int i = 0; i < amountTrees; i++) {
            forest.add(new TreeImpl<>(4));
        }
        return forest;
    }

    public static void fillingTree(ArrayList<TreeImpl<Integer>> forest) {
        Random rand = new Random();
        int min = -25;
        int max = 25;
        int balancedTreeCount = 0;
        int maxDepth = 4;
        int maxNodes = (int) (Math.pow(2, maxDepth) - 1);

        int amountTrees = forest.size();
        for (TreeImpl<Integer> tree : forest) {
            for (int i = 0; i < maxNodes; i++) {
                tree.add((rand.nextInt(max - min) + min));
            }
            if (tree.isBalanced()) {
                balancedTreeCount++;
            }
            tree.display();
        }
        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (amountTrees * 1.0)) * 100) + "%");

    }


    public static void main(String[] args) {
        fillingTree(creatingRandomTrees(20));

    }
}
