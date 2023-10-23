public enum LengthUnit{
    CM{
        public double convertTo(LengthUnit l , double num){
            double metri = num / 100;
            return LengthUnit.M.convertTo(l,metri);

        }
    },M{
        public double convertTo(LengthUnit l , double num){
            if(l == LengthUnit.CM){
                return num*100;
            }
            if(l == LengthUnit.M){
                return num;
            }
            if(l == LengthUnit.KM){
                return num/1000;
            }
            if(l == LengthUnit.INCH){
                return num/0.025;
            }
            if(l == LengthUnit.YARD){
                return num/0.914;
            }
                return num/1609;
            

        }
    },KM{
        public double convertTo(LengthUnit l , double num){
            double metri = num * 1000;
            return LengthUnit.M.convertTo(l,metri);

        }
    },INCH{
        public double convertTo(LengthUnit l , double num){
            double metri = num * 0.025;
            return LengthUnit.M.convertTo(l,metri);

        }
    },YARD{
        public double convertTo(LengthUnit l , double num){
            double metri = num *0.914;
            return LengthUnit.M.convertTo(l,metri);

        }
    },MILE{
        public double convertTo(LengthUnit l , double num){
            double metri = num *1609;
            return LengthUnit.M.convertTo(l,metri);

        }
    };
    public double convertTo(LengthUnit l, double num){
        return 0;
    }
} 