package games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsolBoardTest {

 //   @Test
//    public void generate1() {
//        ConsolCell[][] cells = new ConsolCell[2][2];
//        cells[0][0] = new ConsolCell("*");
//        cells[1][0] = new ConsolCell(" ");
//        cells[1][1] = new ConsolCell(" ");
//        cells[0][1] = new ConsolCell(" ");
//        Assert.assertEquals(ConsolBoard.generate(1,cells), cells);
//    }

    @Test
    public void checkCountOfBomb1() {
        ConsolBoard cells = new ConsolBoard(4,4,17);
        Assert.assertEquals(ConsolBoard.checkCountOfBomb(17), false );
    }
    @Test
    public void checkCountOfBomb2() {
        ConsolBoard cells = new ConsolBoard(4,4,1);
        Assert.assertEquals(ConsolBoard.checkCountOfBomb(1), true );
    }

    @Test
    public void checkCountOfBomb3() {
        ConsolBoard cells = new ConsolBoard(4,4,0);
        Assert.assertEquals(ConsolBoard.checkCountOfBomb(0), false );
    }
    @Test
    public void checkCountOfBomb4() {
        ConsolBoard cells = new ConsolBoard(4,4,-1);
        Assert.assertEquals(ConsolBoard.checkCountOfBomb(-1), false );
    }
    @Test
    public void checkCountOfBomb5() {
        ConsolBoard cells = new ConsolBoard(4,4,2);
        Assert.assertEquals(ConsolBoard.checkCountOfBomb(2), true );
    }
    @Test
    public void number(){
        ConsolCell[][] example  = new ConsolCell[3][3];
        example[0][0]= new ConsolCell("*");
        example[1][0]= new ConsolCell(" ");
        example[2][0]= new ConsolCell(" ");
        example[1][1]= new ConsolCell(" ");
        example[1][2]= new ConsolCell(" ");
        example[2][2]= new ConsolCell(" ");
        example[2][1]= new ConsolCell(" ");
        example[0][1]= new ConsolCell(" ");
        example[0][2]= new ConsolCell(" ");
        ConsolBoard a = new ConsolBoard(example);

        Assert.assertEquals(a.number(1,0),"1");
    }
    @Test
    public void number1(){
        ConsolCell[][] example  = new ConsolCell[3][3];
        example[0][0]= new ConsolCell("*");
        example[1][0]= new ConsolCell(" ");
        example[2][0]= new ConsolCell(" ");
        example[1][1]= new ConsolCell(" ");
        example[1][2]= new ConsolCell(" ");
        example[2][2]= new ConsolCell(" ");
        example[2][1]= new ConsolCell(" ");
        example[0][1]= new ConsolCell(" ");
        example[0][2]= new ConsolCell(" ");
        ConsolBoard a = new ConsolBoard(example);

        Assert.assertEquals(a.number(0,0),"1");
    }
    @Test
    public void number2(){
        ConsolCell[][] example  = new ConsolCell[3][3];
        example[0][0]= new ConsolCell("*");
        example[1][0]= new ConsolCell(" ");
        example[2][0]= new ConsolCell(" ");
        example[1][1]= new ConsolCell(" ");
        example[1][2]= new ConsolCell(" ");
        example[2][2]= new ConsolCell(" ");
        example[2][1]= new ConsolCell(" ");
        example[0][1]= new ConsolCell(" ");
        example[0][2]= new ConsolCell(" ");
        ConsolBoard a = new ConsolBoard(example);

        Assert.assertEquals(a.number(2,2)," ");
    }
}