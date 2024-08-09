package org.example.monty_play;

import java.util.HashMap;
import java.util.Random;
import lombok.Getter;


public class MontyPlay {

    @Getter
   
  private final int NUM_DOORS = 3;
  private final int CAR_DOOR = 1;
  private Random random;

    public MontyPlay() {

        random = new Random();

    }


    public int chooseDoor() {

        return random.nextInt(NUM_DOORS) + 1;

    }

    public int openDoor(int chosenDoor) {

        int openedDoor;

        do {

            openedDoor = random.nextInt(NUM_DOORS) + 1;

        } while (openedDoor == chosenDoor || openedDoor == CAR_DOOR);

        return openedDoor;

    }

    public int switchDoor(int chosenDoor, int openedDoor) {

        int newDoor;

        do {

            newDoor = random.nextInt(NUM_DOORS) + 1;

        } while (newDoor == chosenDoor || newDoor == openedDoor);

        return newDoor;

    }

    public HashMap<String, Double> playGame(int numIterations) {

        HashMap<String, Double> results = new HashMap<>();

        double switchWins = 0;

        double stayWins = 0;

        for (int i = 0; i < numIterations; i++) {

            int chosenDoor = chooseDoor();

            int openedDoor = openDoor(chosenDoor);

            int switchedDoor = switchDoor(chosenDoor, openedDoor);

            if (chosenDoor == CAR_DOOR) {

                stayWins++;
                results.put("оставили первоначальный выбор", stayWins);

            } else if (switchedDoor == CAR_DOOR) {

                switchWins++;
                results.put("изменили выбор", switchWins);
            }

        }

            return results;
    }



    public void getResult(int totalIterations, HashMap<String, Double> results)

     {
      double switchWinPercentage = (results.get("изменили выбор") * 100.0) / totalIterations;
      
       double stayWinPercentage = (results.get("оставили первоначальный выбор") * 100.0) / totalIterations;

        System.out.println("С призом выиграл при смене двери: " + switchWinPercentage + "%");

        System.out.println("С призом выиграл при оставлении первоначального выбора: " + stayWinPercentage + "%");

    }


}
