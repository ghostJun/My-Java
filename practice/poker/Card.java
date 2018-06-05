package poker;

public class Card {
    private Integer num;
    private String color;

    public Card(Integer num, String color) {
        this.num = num;
        this.color = color;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
