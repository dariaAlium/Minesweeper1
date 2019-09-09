package games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MineSweeperTest {

    @Test
    public void shouldBang1() {
        ConsolBoard a = new ConsolBoard(1,1,1);
        Assert.assertEquals(MineSweeper.shouldBang(0,0),false);
    }



}