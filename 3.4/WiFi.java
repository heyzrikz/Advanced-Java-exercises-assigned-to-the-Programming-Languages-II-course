import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class WiFi implements Iterable<WiFi.Network>{

        public class Network implements Comparable{
            private String ssid;
            private double intensita;
        
            Network(String s , double i){
                if(i > 0) throw new IllegalArgumentException();
                ssid = s;
                intensita = i;
            }
        
            public int compareTo(Object o){
                if(!(o.getClass() == getClass())) throw new IllegalArgumentException();
                Network n = (Network) o;
                if(intensita > n.intensita) return 1;
                if(intensita < n.intensita) return -1;
                return 0;
            }
        
            public void updateStrength(double i){
                if(i>0) throw new IllegalArgumentException();
                intensita = i;
            }

            public String toString(){
                return ssid+" ("+intensita+" dBm)";
            }
        
        }
        
    private List<Network> elenco_wifi;
    WiFi(){
        elenco_wifi = new LinkedList<Network>();
    }

    public Network addNetwork(String name, double segnale){
        Network n = new Network(name,segnale);
        elenco_wifi.add(n);
        return n;
    }

    public Network strongest(){
        double max = -999999999;
        Network ret = null;
        for(Network n:elenco_wifi){
            if(n.intensita > max){
                max = n.intensita;
                ret = n;
            }
        }
        return ret;
    }

    public Iterator<WiFi.Network> iterator(){
        return elenco_wifi.iterator();
    }

}