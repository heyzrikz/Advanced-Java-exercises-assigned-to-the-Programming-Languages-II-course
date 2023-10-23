public class Time implements Comparable <Time>{
    private int hour,min,sec;
    
    public Time(int h, int m, int s){
        hour = h;
        min = m;
        sec = s;
    }

    public static final Time MIDDAY = new Time(12,00,00);
    public static final Time MIDNIGHT = new Time(00,00,00);


    public int compareTo(Time t){
         int cmp = Integer.valueOf(hour).compareTo(t.hour);
        if(cmp != 0)return cmp;
            cmp = Integer.valueOf(min).compareTo(t.min);
        if(cmp != 0)return cmp;
            cmp = Integer.valueOf(sec).compareTo(t.sec);
            return cmp;                     
    }
    public String toString(){
        return hour+":"+min+":"+sec;
    }

    public Time minus(Time x){
        int h = hour - x.hour , 
            m = min - x.min , 
            s = sec - x.sec;
            if(hour < x.hour){
                h = 24 - (hour - x.hour);
            }
            if(min < x.min){
                m = 60 - (min - x.min);
                h--;
            }
            if(sec < x.sec){
                s = 60 + (sec- x.sec);
                m--;
                if(m < 0){
                    h--;
                    m = 59;
                }
            }
        return new Time(h,m,s);
        
    }



}
