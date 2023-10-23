public class Main {
    public static void main(String[] args){
    Accumulator<Integer> acc1 = new Accumulator<>();
acc1.add(10);
acc1.add(42);
acc1.add(-5);
acc1.add(10);
for (Integer n: acc1. positives ()) System.out.println(n);
for (Integer n: acc1.negatives()) System.out.println(n);
Accumulator<Double> acc2 = new Accumulator<>();
acc2.add(-10.0);
acc2.add(42.0);
System.out.println(acc2.sum());
acc1.positives().add(5); //dovrebbe dare errore di compilazione ma non lo da 
    }
}
