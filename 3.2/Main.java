public class Main{
    public static void main(String[] args){
        Radio r = new Radio();
Radio.Channel rai1 = r.addChannel("Rai Radio Uno", 89.3);
Radio.Channel kk = r.addChannel("Radio Kiss Kiss", 101.4);
Radio.Channel rmc = r.addChannel("Radio Monte Carlo", 96.4)
;
for (Radio.Channel c: r) {
System.out.println(c);
}
System.out.println(r.nearest(98.1) );
    }
}