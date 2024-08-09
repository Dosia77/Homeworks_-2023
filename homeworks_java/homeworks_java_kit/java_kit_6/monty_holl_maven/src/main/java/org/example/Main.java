package org.example;
//import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.example.monty_play.*;;

public class Main {
    public static void main(String[] args) {
     
      MontyPlay game = new MontyPlay();
      // DescriptiveStatistics descript = new DescriptiveStatistics();
     System.out.println(game.playGame(1000));
     game.getResult(1000, game.playGame(1000));

    }
}