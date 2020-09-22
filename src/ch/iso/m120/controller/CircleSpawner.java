package ch.iso.m120.controller;

import ch.iso.m120.view.Circle;

import java.util.ArrayList;
import java.util.Random;

public class CircleSpawner {
    private ArrayList<Integer> spawnOrder;
    private Random generator;
    private int pointer;
    private int bpm;




     public CircleSpawner(int seed, int durationInSeconds, int bpm) {
         super();
         this.generator = new Random(seed);
         this.spawnOrder = new ArrayList<>();
         this.pointer = 0;
         this.bpm = bpm;
         for (int i = 0; i < (durationInSeconds*(bpm/60)); i++) {
             spawnOrder.add(generator.nextInt(4));
         }


    }

    public Circle getNextCircle() {
         if (pointer < spawnOrder.size()) {
             return new Circle(spawnOrder.get(pointer++),bpm);
         } else {
             return new Circle(0,bpm);
         }


    }
}
