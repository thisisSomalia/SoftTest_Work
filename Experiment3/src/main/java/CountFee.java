import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CountFee {

    private String startingTime;
    private String endingTime;
    private long minute;//通话时长
    public Date startT;
    public Date endT;

    public CountFee(String startingTime, String endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.startT = StrToDate(this.startingTime);
        this.endT = StrToDate(this.endingTime);
    }

    public Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String DateFormate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sdate = format.format(date);
        return sdate;
    }

    public long getHoldingTime() {
        long between;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startT);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endT);
        if ((cal1.get(Calendar.MONTH) == Calendar.MARCH)  || (cal1.get(Calendar.MONTH) == Calendar.OCTOBER)) {
            if ((cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && (cal1.get(Calendar.DATE) + 7 >= 31)) {
                between = cal2.getTime().getTime() - cal1.getTime().getTime();
                between = between / 1000;
                minute = between / 60;
                if (between % 60 > 0) {
                    minute += 1;
                }
                if (cal1.get(Calendar.MONTH) == Calendar.MARCH) {
                    if (cal1.get(Calendar.HOUR_OF_DAY) < 2 && cal2.get(Calendar.HOUR_OF_DAY) >= 3) {
                        minute -= 60;
                    }
                }
                else if(cal1.get(Calendar.MONTH)==Calendar.OCTOBER){
                    if(cal1.get(Calendar.HOUR_OF_DAY)<3&&cal2.get(Calendar.HOUR_OF_DAY)>=2){
                        minute +=60;
                    }
                }
            } else {
                between = cal2.getTime().getTime() - cal1.getTime().getTime();
                between = between / 1000;
                minute = between / 60;
                if (between % 60 > 0) {
                    minute += 1;
                }
            }
        } else {
            between = cal2.getTime().getTime() - cal1.getTime().getTime();
            between = between / 1000;
            minute = between / 60;
            if (between % 60 > 0) {
                minute += 1;
            }
        }
       return minute;
    }

    public static String count(String startTime, String endTime) {
        double telFee;
        CountFee ht = new CountFee(startTime, endTime);
        DecimalFormat df = new DecimalFormat("######0.00");
        long minute = ht.getHoldingTime();
        if (minute <= 20) {
            telFee = 0.05 * minute;
        } else {
            telFee = 1.00 + (minute - 20) * 0.1;
        }
        return "话费为" + df.format(telFee) + "美元";
    }
}



