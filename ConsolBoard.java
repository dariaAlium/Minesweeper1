package games;

public class ConsolBoard implements Board {

    static ConsolCell[][] cells;
    static private int x, y;

    ConsolBoard(ConsolCell[][] cells) {
        this.cells = cells;
    }

    ConsolBoard(int x, int y, int CountOfBomb) {
        this.x = x;
        this.y = y;

        cells = new ConsolCell[x][y];

        cells = moreRandomGenerate(CountOfBomb, cells);
    }

    public void drawBoard() {
        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++)
                cells[x][y].draw();
            System.out.println();
        }
        System.out.print("\n\n");
    }

    public void drawCongratulate() {
        System.out.print("Ну в этот раз ты прав");
    }

    public static ConsolCell[][] moreRandomGenerate(int count, ConsolCell[][] cells) {
        if (checkCountOfBomb(count)) {
            int[] binar = newRand(count);
            for (int iter = 0; iter < count; iter++){
                if (binar[iter] % x == 0) cells[x - 1][binar[iter] / x - 1] = new ConsolCell("*");
                else cells[binar[iter] % x - 1][binar[iter] / x] = new ConsolCell("*");}

                for (int x1 = 0; x1 < x; x1++)
                for (int y1 = 0; y1 < y; y1++)
                    try {
                        if (cells[x1][y1].isBomb()) ;
                    } catch (NullPointerException a) {
                        cells[x1][y1] = new ConsolCell(" ");
                    }

            for (int x1 = 0; x1 < x; x1++)
                for (int y1 = 0; y1 < y; y1++)
                    if (!cells[x1][y1].isBomb()) cells[x1][y1].setValue(number(x1, y1));

            return cells;

        } else {
            System.out.println("Тууууууууу мач бомб");
            System.exit(0);
            return null;
        }

    }

    //метод который контролирует частоту бомб
    public static boolean checkCountOfBomb(int count) {
        if (count > x * y || count <= 0) return false;
        return true;
    }

    static int[] newRand(int count) {
        int[] binar = new int[count];
        binar[0] = 1 + (int) (Math.random() * (x * y - 1));
        for (int l = 1; l < binar.length; l++) {
            int add = (int) (Math.random() * (x * y));
            boolean equal = true;
            for (int p = 0; p < binar.length; p++)
                if (add == binar[p]) equal = false;
            if (equal) binar[l] = add;
            else l--;

        }
        return binar;
    }

    static public String number(int x1, int y1) {
        int num = 0;

        for (int x2 = x1 - 1; x2 < x1 + 2; x2++)
            for (int y2 = y1 - 1; y2 < y1 + 2; y2++)
                try {
                    if (cells[x2][y2].isBomb()) num++;

                } catch (ArrayIndexOutOfBoundsException a) {

                }
        if (num == 0) return " ";
        return Integer.toString(num);
    }

    public static boolean shouldFinish(){
        for(int x1=0;x1<x;x1++)
            for(int y1=0;y1<y;y1++)
                if(cells[x1][y1].open());
                else return false;
                return true;
    }

}
