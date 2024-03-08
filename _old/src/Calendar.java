import java.util.Date;

public class Calendar {


    public static void main(String[] args){

        Calendar util = new Calendar();
        util.getNumberOfDaysInCurrentMonth();

        System.out.println(util.getCurrentNumberOfDaysInMonth());
    }


    public void getNumberOfDaysInCurrentMonth() {

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int monthMaxDays = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        System.out.println("========="+ monthMaxDays);
    }

    public int getCurrentNumberOfDaysInMonth() {
        Date date = new Date();
        return date.getDate();
    }
}
