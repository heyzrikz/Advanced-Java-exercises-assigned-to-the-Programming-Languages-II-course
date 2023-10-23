import java.util.Comparator;
import java.util.TreeMap;

class PriorityExecutor extends Thread{
    private TreeMap<Integer,Runnable> tasks = new TreeMap<>(new Comparator<Integer>(){
        public int compare(Integer a , Integer b){
            if(a > b) return -1;
            if(a < b) return 1;
            return 0;
        }
    });

    public void addTask(Runnable r , int priority){
        System.out.println("inserisco "+priority);
            tasks.put(priority,r);
        
    }

    public void run(){
            while(tasks.size() > 0){
                    try {
                        Runnable r = tasks.get(tasks.firstKey());
                        Integer first = (tasks.firstKey());
                        Thread th = new Thread(r);
                        System.out.println("eseguo "+first);
                        th.start();
                        th.join();
                        tasks.remove(first);
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                    
            
        }
       
    }
    public static void main(String[] args) {
        Runnable r1 = new Runnable(){
            public void run(){
                System.out.println("r1");
            }
        }, r2 = new Runnable(){
            public void run(){
                System.out.println("r2");
            }
        };
PriorityExecutor e = new PriorityExecutor();
e.addTask(r2, 10);
e.addTask(r1, 100);
e. start () ;
e.addTask(r2, 15);
e.addTask(r1, 50);

    }
}