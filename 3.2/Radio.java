import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Radio implements Iterable<Radio.Channel>{
    private static final double MAX_FREQ = 99999999;

    private Channel curr;

    private LinkedList<Channel> canali = new LinkedList<>();

    public class Channel{
        private String nome;
        private double frequenza;
        Channel(){}
        Channel(String n , double f){
            nome = n;
            frequenza = f;
        }
        public double getFrequenza(){
            return frequenza;
        }

        public String getNome(){
            return nome;
        }

        public String toString(){
            return nome+" ("+frequenza+")";
        }
    }

    

    public Channel addChannel(String nome,double frequenza) throws Error{
        for(Channel ch:canali){
            if(ch.getFrequenza() == frequenza){
                throw new Error();
            }
        }

        Channel c = new Channel(nome,frequenza);
        if(canali.size() == 0){curr = c;}
        canali.add(c);
        return c;

    }

    public Channel nearest(double frequenza){
        double differenza = MAX_FREQ;
        Channel ret = null;
        for(Channel ch:canali){
            if((frequenza - ch.getFrequenza())>0 && ((frequenza - ch.getFrequenza())) < differenza){
                ret = ch;
                differenza = frequenza - ch.getFrequenza();
            }
            if((frequenza - ch.getFrequenza())<0 && ((frequenza - ch.getFrequenza())*(-1)) < differenza){
                ret = ch;
                differenza = (frequenza - ch.getFrequenza())*(-1);
            }
        }
        return ret;
    }

   

    @Override
    public Iterator<Radio.Channel> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<Radio.Channel>() {

            public boolean hasNext(){
                if(curr == null) return false;
                else return true;
            }
        
            public Channel next(){
                double differenza = MAX_FREQ;
                if(hasNext()){
                    Channel ret = null;
                for (Channel ch: canali){
                    if((ch.frequenza - curr.getFrequenza())>0 && ((ch.frequenza - curr.getFrequenza())) < differenza){
                        ret = ch;
                        differenza = ch.frequenza - curr.getFrequenza();
                    }
                }
                Channel tmp;
                tmp = curr;
                curr = ret;
                return tmp;
            }else  throw new NoSuchElementException();
            }
        
            public void remove(){
                if(hasNext()){
                    canali.remove(next());
                }
            }
            
        };
    }


   
}