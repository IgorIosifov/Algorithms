package Lesson_5;

import java.util.*;

public class KnapsackProblem {


    private int totalLootCost;
    private float totalLootWeight;
    private final float capacity = 3.0f;

    Items notebook = new Items("notebook", 1000, 1.0f);
    Items smartphone = new Items("smartphone", 1000, 0.5f);
    Items rareCoin = new Items("rare coin", 500, 0.1f);
    Items camera = new Items("camera", 1800, 2.0f);
    Items goldChain = new Items("gold chane", 2000, 0.1f);

    Items[] items = {notebook, smartphone, rareCoin, camera, goldChain};
    List<Items> totalLootSet = new ArrayList<>();
    List<List<Items>> possibleCombinations = new ArrayList<>();

    private void solvingKnapsackProblem() {

        for (int i = 0; i < items.length; i++) {

            for (int z = 0; z < items.length - 1; z++) {
                oneThingCase(z);

                shift(4);
//                checkUniqueLootSet();
                resultCost();
                totalLootSet.clear();
            }
            shift(5);
        }
        System.out.println(possibleCombinations.get(1).get(1).getName());

    }

    private void checkUniqueLootSet() {


        List<String> currentNames = new ArrayList<>();
        for (int j = 0; j < totalLootSet.size(); j++) {
            currentNames.add(totalLootSet.get(j).getName());
        }
        Collections.sort(currentNames);
        for (int i = 0; i < possibleCombinations.size(); i++) {
            if (!currentNames.equals(possibleCombinations.get(i))) {

            }
        }


    }


    private void display() {
        System.out.println("------");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getName());
        }
        System.out.println("------");
    }

    private void shift(int lenght) {
        int pos = items.length - lenght;
        Items temp = items[pos];
        for (int i = pos + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[items.length - 1] = temp;
    }

    private void oneThingCase(int i) {


        while (i < items.length) {
            totalLootSet.add(items[i]);
            if (resultWeight() <= capacity) {
                i++;
                oneThingCase(i);
            } else {
                totalLootSet.remove(items[i]);
                oneThingCase(++i);
            }
            break;
        }

    }


    private void result() {
        for (int i = 0; i <possibleCombinations.size() ; i++) {
                resultNames(possibleCombinations.get(i));
            }

            System.out.println("total cost =" + resultCost() + "$ ; " + "total weight = " + resultWeight() + " kg.");
            for (Items it : totalLootSet) {
                System.out.println(it.getName());

            }
        }


    private int resultCost() {
        int currentLootCost = 0;
        for (Items it : totalLootSet) {
            currentLootCost += it.getCost();
        }
        if (currentLootCost>=totalLootCost){
            totalLootCost = currentLootCost;
            possibleCombinations.add(totalLootSet);
        }
        return totalLootCost;
    }

    private float resultWeight() {
        totalLootWeight = 0;
        for (Items it : totalLootSet) {
            totalLootWeight += it.getWeight();
        }
        return totalLootWeight;
    }

    private void resultNames(List<Items> totalLootSet) {
            StringBuilder resultNames=null;
        for (int i = 0; i < totalLootSet.size(); i++) {
            resultNames.append(totalLootSet.get(i).getName());
            resultNames.append(";");
        }
        System.out.println(resultNames);
    }


    public static void main(String[] args) {
        KnapsackProblem case1 = new KnapsackProblem();
        case1.solvingKnapsackProblem();
    }
}
