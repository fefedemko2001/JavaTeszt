
public class Main{

    public static void main(String[] args) {
            if (args.length != 1) 
            {
                System.out.println("Nincs kosarad");
                
            }
            else{
                Cart proba = new Cart(args[0]);
                System.out.println(proba.getSum());
            }
        }
}
