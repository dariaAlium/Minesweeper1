package games;

import java.util.Objects;

class ConsolCell implements Cell {
    private MineSweeper a = new MineSweeper();
    private String value, suggestValue;

    ConsolCell(String value) {
        this.value = value;
        suggestValue = "#";
    }

    public void setValue(String value) {
        this.value = value;
    }

    //проверка явл ли клетка бомбой
    public boolean isBomb() {
        return value.equals("*");
    }

     boolean open(){
        return value.equals(suggestValue)||(isBomb()&&!isSuggestEmpty());
     }

    public String getValue() {
        return value;
    }

    public boolean isSuggestEmpty() {
        return suggestValue.equals("0");
    }

    //когда предп что пустая
    public void suggestEmpty() {
        if (isBomb()) a.finish();
        if(suggestValue==value) System.out.print("Хватит валять дурака");
        else suggestValue=value;
    }

    //когда предп что бомба
    public void suggestBomb() {
        suggestValue = "!";
    }

    //нарисов клетку
    public void draw() {
         System.out.print("["+suggestValue+"]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsolCell)) return false;
        ConsolCell that = (ConsolCell) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(suggestValue, that.suggestValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suggestValue);
    }
}
