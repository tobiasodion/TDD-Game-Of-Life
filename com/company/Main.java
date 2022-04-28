package com.company;
import GOL.Coord;
import GOL.GameOfLife;

public class Main {

    public static Coord[] InitialAliveCells(){
        Coord[] coords = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
        };

        return coords;
    }

    public static void main(String[] args) {
        try{
            Coord[] initialCells = InitialAliveCells();
            GameOfLife gol = new GameOfLife(5, 5, initialCells);
            gol.ComputeNthGeneration(10);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
