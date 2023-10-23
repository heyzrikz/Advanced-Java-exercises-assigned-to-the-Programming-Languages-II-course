
    
public class Main {

	public static void main(String[] args) {
	/* -ESERCIZIO 1.3
	Box b1 = new Box();
	Box b2 = new Box();
	ColoredBox cb1 = new ColoredBox();
	ColoredBox cb2 = new ColoredBox();
	b1.setX(10);
	b1.setY(5);
	b2.setX(10);
	b2.setY(5);
	cb1.setX(10);
	cb1.setY(5);
	cb1.setColor("bianco");
	cb2.setX(10);
	cb2.setY(5);
	cb2.setColor("bianco");
	if(cb2.equals(cb1)) System.out.println("uguali");
	else System.out.println("diversi");
	*/
	/* -ESERCIZIO 1.4
		Fraction a = new Fraction(12,30), b = new ReducedFraction(12,30),
				c = new Fraction(1,4), d = c.times(a);
				System.out.println(a.res);
				System.out.println(b.res);
				System.out.println(d.res);
				System.out.println(a.equals(b));
				System.out.println(c.times(b).res);
		
	*/	
		Studente.Triennale. setPrefisso ("N86");
		Studente.Magistrale. setPrefisso ("N97");
		Studente luca1 = new Studente.Triennale("Luca", "004312"),
		luca2 = new Studente.Triennale("Luca", "004312"),
		anna1 = new Studente.Triennale("Anna", "004312"),
		anna2 = new Studente.Magistrale("Anna", "004312");
		System.out.println(luca1.equals(luca2));
		System.out.println(anna1.equals(anna2));
		System.out.println(anna1.getValues());
	}

}


