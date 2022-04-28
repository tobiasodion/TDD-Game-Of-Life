package Tests;

import GOL.Coord;
import GOL.GameOfLife;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {
    GameOfLife gameOfLifeTest;
    int testRowCount = 4;
    int testColumCount = 5;
    Coord[] testCoords = { };

    @Before
    public void setUp(){
        gameOfLifeTest = new GameOfLife(testRowCount,testColumCount, testCoords);
    }

    @Test (expected = RuntimeException.class)
    public void initializeGrid(){
        gameOfLifeTest = new GameOfLife(1,1, testCoords);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void init_GridValueOutOfBoundException(){
        gameOfLifeTest.Init();
        int result = gameOfLifeTest.grid[5][7];
    }

    @Test
    public void init_AllCellsZeroAfterInit(){
       for(int i = 0; i<testRowCount; i++){
           for (int j = 0; j<testColumCount; j++){
               assertEquals(0, gameOfLifeTest.grid[i][j]);
           }
       }
    }

    @Test
    public void setLivingCells_setMultipleCells(){
        testCoords = new Coord[] {
                new Coord(2,0),
                new Coord(3,3),
                new Coord(3,4),
        };

        gameOfLifeTest = new GameOfLife(testRowCount,testColumCount, testCoords);

        assertEquals(1, gameOfLifeTest.grid[2][0]);
        assertEquals(1, gameOfLifeTest.grid[3][3]);
        assertEquals(1, gameOfLifeTest.grid[3][4]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setLivingCells_setMultipleCellsOutOfBoundException(){
        testCoords = new Coord[] {
                new Coord(4,5),
                new Coord(3,6),
                new Coord(4,6),
        };

        gameOfLifeTest = new GameOfLife(testRowCount,testColumCount, testCoords);
    }

    @Test
    public void setLivingCells_setSingleCell(){
        assertEquals(0, gameOfLifeTest.grid[2][4]);
        gameOfLifeTest.setLivingCell(2,4);
        assertEquals(1, gameOfLifeTest.grid[2][4]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setLivingCells_setSingleCellOutOfBoundException(){
        gameOfLifeTest.setLivingCell(testRowCount + 1, testColumCount+1);
    }

    @Test
    public void countLivingNeighbours_countNeighboursOfVerticeCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLifeTest.setLivingCell(i,j);
            }
        }

        int result = gameOfLifeTest.countlivingNeighbours(0,0);

        assertEquals(3,result);
    }

    @Test
    public void countLivingNeighbours_countNeighboursOfEdgeCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLifeTest.setLivingCell(i,j);
            }
        }
    }

    @Test
    public void countLivingNeighbours_countNeighboursOfInsideCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLifeTest.setLivingCell(i,j);
            }
        }

        int result = gameOfLifeTest.countlivingNeighbours(1,2);

        assertEquals(8,result);
    }

    @Test
    public void countLivingNeighbours_allNeighboursDead(){
        int verticeCell = gameOfLifeTest.countlivingNeighbours(0,0);
        assertEquals(0,verticeCell);
        int edgeCell = gameOfLifeTest.countlivingNeighbours(0,2);
        assertEquals(0,edgeCell);
        int insideCell = gameOfLifeTest.countlivingNeighbours(1,2);
        assertEquals(0,insideCell);
    }

}