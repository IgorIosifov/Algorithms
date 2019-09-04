package Lesson_5;

import java.util.*;

public class KnapsackProblem {


    private int MaxLootCost;
    private float totalLootWeight;
    private final float capacity = 3.0f;

    private Items notebook = new Items("notebook", 1000, 1.0f);
    private Items smartphone = new Items("smartphone", 1000, 1.0f);
    private Items rareCoin = new Items("rare coin", 1000, 1.0f);
    private Items camera = new Items("camera", 1000, 1.0f);
    private Items goldChain = new Items("gold chane", 1000, 1.0f);

    Items[] items = {notebook, smartphone, rareCoin, camera, goldChain};
    List<Items> lootSet = new ArrayList<>();
    List<List<Items>> possibleCombinations = new ArrayList<>(items.length*items.length);


    private void solvingKnapsackProblem() {
        for (int i = 0; i < items.length; i++) {
            for (int z = 0; z < items.length - 1; z++) {
                lootSet.clear();
                oneThingCase(z);
                if (lootSetIsUnique()) {
                    switch (costIsMax()) {
                        case "costIsMax":
                            possibleCombinations.clear();
                            addToPossibleCombinations();
                            break;
                        case "costIsEqual":
                            addToPossibleCombinations();
                            break;
                        default: {
                            break;
                        }
                    }
                }
                shift(4);
            }
            shift(5);
        }
        display();
    }

    private void addToPossibleCombinations() {
        // this thing just to fill the buffer so Collections.copy() can work properly
        List<Items> buffer = new ArrayList<>(lootSet.size());
        for (int i = 0; i < lootSet.size(); i++) {
            buffer.add(new Items(null, 0, 0));
        }
        Collections.copy(buffer, lootSet);
        possibleCombinations.add(buffer);
    }

    private boolean lootSetIsUnique() {
        lootSetSortedByName(lootSet);
        if (!possibleCombinations.isEmpty()) {
            for (int i = 0; i < possibleCombinations.size(); i++) {
                int uniqueCounter = 0;
                for (int j = 0; j < possibleCombinations.get(i).size(); j++) {
                    if (!lootSet.get(j).getName().equals(possibleCombinations.get(i).get(j).getName())) {
                        break;
                    } else {
                        uniqueCounter++;
                        if (uniqueCounter == lootSet.size()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return true;
    }

    private List<Items> lootSetSortedByName(List<Items> lootSet) {
        List<String> currentNames = new ArrayList<>();
        for (int j = 0; j < lootSet.size(); j++) {
            currentNames.add(lootSet.get(j).getName());
        }
        Collections.sort(currentNames);
        List<Items> sortedLootSet = new ArrayList<>();
        for (int i = 0; i < currentNames.size(); i++) {
            for (int j = 0; j < lootSet.size(); j++) {
                if (lootSet.get(j).getName().equals(currentNames.get(i))) {
                    sortedLootSet.add(lootSet.get(j));
                }
            }
        }
        Collections.copy(lootSet, sortedLootSet);
        sortedLootSet.clear();
        return lootSet;

    }


    private void display() {
        System.out.println(" Expected amount of possible combinations " +
                "is n! / (k! * (n-k)!), where n = 5, k= 3;" +
                "5!/(3!*(5-3)! = 10");
        System.out.println(possibleCombinations.size());
        for (int i = 0; i < possibleCombinations.size(); i++) {
            System.out.println("set #" + i);
            for (int j = 0; j < possibleCombinations.get(i).size(); j++) {
                System.out.print(possibleCombinations.get(i).get(j).getName() + " ");
            }
            System.out.println(resultWeight(possibleCombinations.get(i)));
            System.out.println(MaxLootCost);
        }
    }

    private void shift(int length) {
        int pos = items.length - length;
        Items temp = items[pos];
        for (int i = pos + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[items.length - 1] = temp;
    }

    private void oneThingCase(int i) {
        while (i < items.length) {
            lootSet.add(items[i]);
            if (resultWeight(lootSet) <= capacity) {
                oneThingCase(++i);

            } else {
                lootSet.remove(items[i]);
                oneThingCase(++i);
            }
            break;
        }

    }

    private String costIsMax() {
        int currentLootCost = 0;
        for (Items it : lootSet) {
            currentLootCost += it.getCost();
        }
        if (currentLootCost > MaxLootCost) {
            MaxLootCost = currentLootCost;
            return "costIsMax";
        }
        if (currentLootCost == MaxLootCost) {
            return "costIsEqual";
        } else return "costIsLess";
    }

    private float resultWeight(List <Items> lootSet) {
        totalLootWeight = 0;
        for (Items it : lootSet) {
            totalLootWeight += it.getWeight();
        }
        return totalLootWeight;
    }



    public static void main(String[] args) {
        KnapsackProblem case1 = new KnapsackProblem();
        case1.solvingKnapsackProblem();
    }
}
