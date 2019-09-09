package games;

import java.util.Scanner;

public class MineSweeper {

    static ConsolBoard mainBoard;

    public static void main(String[] args) {
        Scanner numb = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        User u1 = new User("Dasha");
        System.out.println("Добро пожаловать в самую увлекательную игру нашего времени. В САПЕР!!!! " +
                "\nЗдесь вы можете почувствовать себя настоящим гением математики и проявить все свои способности" +
                "\nЧтож, для начала, давай выберем разметку поля." +
                "\nМожешь ввести отрицательное значение, моя программа защищена от хаккерских навыков");
        System.out.print("Введите значение y: ");
        int x =Math.abs(numb.nextInt());
        System.out.print("Введите значение x: ");
        int y =Math.abs(numb.nextInt());
        System.out.print("Введите количество бомб, можете ввести сколько угодно, программа защищена и от этого тоже))) ");
        int count =Math.abs(numb.nextInt());
        mainBoard = new ConsolBoard(x, y, count);
        mainBoard.drawBoard();

        System.out.println("Да начнется игра. Вам необходимо вводить координаты точки");


        System.out.print("Введите значение y: ");
         x =Math.abs(numb.nextInt());
        System.out.print("Введите значение x: ");
         y =Math.abs(numb.nextInt());
        System.out.print("Бомба(!) или нет(0): ");
        String choice = str.nextLine();
            try { u1.select(mainBoard.cells[x][y],choice);
        if(shouldBang(x,y)) finish();
        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Плизки, соблюдайте размерность");
        }



        mainBoard.drawBoard();
        do {
            try {
                System.out.print("Введите значение y: ");
                x = Math.abs(numb.nextInt());
                System.out.print("Введите значение x: ");
                y = Math.abs(numb.nextInt());
                System.out.print("Бомба(!) или нет(0): ");
                choice = str.next();
                u1.select(mainBoard.cells[x][y], choice);
                mainBoard.drawBoard();
                if(shouldBang(x,y))finish();
            }catch (ArrayIndexOutOfBoundsException a){
                System.out.println("Плизки, соблюдайте размерность");
            }
        } while (!mainBoard.shouldFinish());
        mainBoard.drawCongratulate();
System.exit(0);

    }

    static public boolean shouldBang(int x, int y) {
        return mainBoard.cells[x][y].isSuggestEmpty() && mainBoard.cells[x][y].isBomb();

    }

    static public void finish() {
        System.out.print("АХААХАХАХ ТЫ МЕРТВЫЙ САПЕР");
        System.exit(0);
    }


}
