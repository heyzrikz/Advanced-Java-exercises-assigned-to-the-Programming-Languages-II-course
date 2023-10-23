public class Main {
    public static void main(String arg[]){
        BoundedMap<String,String> m = new BoundedMap<String,String>(2);
m.put("NA", "Napoli");
m.put("SA", "Salerno");
System.out.println(m.get("NA"));
m.put("AV", "Avellino");
System.out.println(m.get("SA"));


    }
}
