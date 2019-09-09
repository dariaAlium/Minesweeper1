package games;

public class User implements UserAction {

    String name;

    User(String name){
        this.name=name;
    }

    public void select(ConsolCell cell, String choice){
        if(choice.equals("!")) cell.suggestBomb();
        else if(choice.equals("0")) cell.suggestEmpty();
        else System.out.print("Вы можете выбрать лишь бомбу или пустоту..");

    }
}
