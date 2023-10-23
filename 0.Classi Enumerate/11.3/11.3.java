enum Status{
    ONLINE(true),BUSY(true),HIDDEN(false),OFFLINE(false);
    private boolean visibility;
    private Status(boolean vis){
        visibility = vis;
    }
    public boolean isVisible(){
        return visibility;
    }

    public boolean canContact(Status x){
        return (this != Status.OFFLINE) && (x.isVisible());
    }

}

 class Main {
    public static void main(String arg[]){
        Status a = Status.BUSY, b = Status.HIDDEN;
System.out.println(a. isVisible ());
System.out.println(a.canContact(b));
    }
}