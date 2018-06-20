import date.DateTranslate;
import poker.Poker;
import sort.SortMethod;


public class Test {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.suffer();
        SortMethod sortMethod = new SortMethod();
        int[] nums = {1, 0, 20, 11, 7, 9};
        nums = sortMethod.bubbleSort(nums);
        System.out.println(nums);
        DateTranslate dateTranslate = new DateTranslate();
        dateTranslate.getDateByCalendar();
        dateTranslate.getDateByLocalDateTime();
        dateTranslate.getLastDay();
    }
}
