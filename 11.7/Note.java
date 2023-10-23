public enum Note{
    DO{
        public int getSemitono(){
            return 0;
        }
    },RE{
        public int getSemitono(){
            return 2;
        }
    },MI{
        public int getSemitono(){
            return 4;
        }
    },FA{
        public int getSemitono(){
            return 5;
        }
    },SOL{
        public int getSemitono(){
            return 7;
        }
    },LA{
        public int getSemitono(){
            return 9;
        }
    },SI{
        public int getSemitono(){
            return 11;
        }
    };
    public int getSemitono(){
        return 0;
    }
    public int interval(Note n){
        return n.getSemitono() - this.getSemitono();
    }
}