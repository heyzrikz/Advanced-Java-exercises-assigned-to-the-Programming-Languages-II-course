class SumAndMax{
    public static double[] sumAndMax(double[] arr){
         double[] ret = new double[2];
        
        Thread max = new Thread(()->{
            int i = 0;
            while(! Thread.currentThread().isInterrupted() && i < arr.length){
                if(arr[i] > ret[1]) ret[1] = arr[i];
                i++;
            }
        });

        Thread sum = new Thread(()->{
            for(Double d : arr){
                ret[0] = ret[0] + d;
                if(ret[0] >= Double.POSITIVE_INFINITY || ret[0] <= Double.NEGATIVE_INFINITY){
                    max.interrupt();
                    Thread.currentThread().interrupt();
                } 
            }
        });
        max.start();
        sum.start();
        try {
            max.join();
            sum.join();
        } catch (InterruptedException e) {
            return null;
        }
        
        return ret;
    }
}
class Main{
    public static void main(String arg[]) throws InterruptedException{
        double[] array = new double[]{2.0,9000000000000000000000000000000.0,99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.0,2.0,5.0};
        double[] a = SumAndMax.sumAndMax(array); 
        for(int i = 0 ; i < 2 ; i++){
            System.out.println(a[i]);
        }
    }
}