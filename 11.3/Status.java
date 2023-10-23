public enum Status{
    ONLINE{
        public boolean isVisible(){
            return true;
        }
    },BUSY{
        public boolean isVisible(){
            return true;
        }
    },HIDDEN{
        public boolean isVisible(){
            return false;
        }
    },OFFLINE{
        public boolean isVisible(){
            return false;
        }
    };

    public boolean canContact(Status s){
        if(this != Status.OFFLINE && s.isVisible()) return true;
        else return false;
    }

    public boolean isVisible(){
        return true;
    }

}