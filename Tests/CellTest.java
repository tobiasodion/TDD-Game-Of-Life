package Tests;

import GOL.Cell;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void LivingCellAliveWithNoLivingNeighbours(){
        Cell testCell = new Cell(1,0);
        assertEquals(0, testCell.NextState());
    }

    @Test
    public void LivingCellAliveWithOneLivingNeighbours(){
        Cell testCell = new Cell(1,1);
        assertEquals(0, testCell.NextState());
    }

    @Test
    public void LivingCellAliveWithTwoLivingNeighbours(){
        Cell testCell = new Cell(1,2);
        assertEquals(1, testCell.NextState());
    }

    @Test
    public void LivingCellAliveWithThreeLivingNeighbours(){
        Cell testCell = new Cell(1,3);
        assertEquals(1, testCell.NextState());
    }

    @Test
    public void LivingCellAliveWithFourLivingNeighbours(){
        Cell testCell = new Cell(1,4);
        assertEquals(0, testCell.NextState());
    }

    @Test
    public void DeadCellAliveWithThreeLivingNeighbours(){
        Cell testCell = new Cell(0,3);
        assertEquals(1, testCell.NextState());
    }

    @Test
    public void DeadCellDeadWithTwoLivingNeighbours(){
        Cell testCell = new Cell(0,2);
        assertEquals(0, testCell.NextState());
    }

    @Test
    public void DeadCellDeadWithFourLivingNeighbours(){
        Cell testCell = new Cell(0,4);
        assertEquals(0, testCell.NextState());
    }
}