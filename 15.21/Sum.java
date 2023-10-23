public class Sum{

    

    public static double[] sumAndMax(double[] array) throws InterruptedException{
        double[] ret = new double[2];

        Thread max = new Thread(new Runnable(){
            public void run(){
                for(int i = 0 ; i < array.length ; i++){
                    if(array[i] > ret[1]) ret[1] = array[i];
                }
            }
            });
            max.start();

        Thread sum = new Thread(new Runnable(){
            public void run(){
                for(int i = 0 ; i < array.length ; i++){
                    ret[0] = ret[0] + array[i];
                    if(ret[0] >= Double.POSITIVE_INFINITY || ret[0] <= Double.NEGATIVE_INFINITY)
                        max.interrupt();
                }
            }
            });
            sum.start();

            max.join();
            sum.join();
            if(max.isInterrupted()) return null;
            return ret;
            
    }


}

class Main{
    public static void main(String arg[]) throws InterruptedException{
        double[] array = new double[]{2.0,9000000000000000000000000000000.0,99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.0,2.0,5.0};
        double[] a = Sum.sumAndMax(array); 
        for(int i = 0 ; i < 2 ; i++){
            System.out.println(a[i]);
        }
    }
}