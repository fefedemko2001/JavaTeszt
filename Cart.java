import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart 
{
    private ArrayList<Item> items = new ArrayList<Item>();
    private double sum = 0;
    private Map<Character,Integer> catalog = new HashMap<>();

    public Cart(String given)
    {
       var list = given.toCharArray();
       for (char c : list) {
        if (Character.isLetter(c)){
            try{
               items.add(new Item(c));
               catalog.put(c, catalog.getOrDefault(c, 0) + 1);
            }
            catch(IllegalArgumentException e) {
                System.out.println("HIBA: " + e.getMessage());
            }
        }
       }
    }

    private int Rule1()
    {
        int cnt = 0;
        int a = catalog.getOrDefault('A',0);
        int c = catalog.getOrDefault('C',0);
        if (c <= a/2){
            cnt = c;
        }
        else{
            cnt = a/2;
        }
        return cnt;
    }

    private int Rule2()
    {
        double cnt = 0;
        int d =catalog.getOrDefault('D',0);
        cnt = Math.floor(d/3.0);
        return (int) cnt;
    }

    private boolean Rule3()
    {
        boolean result = false;
        if (catalog.getOrDefault('D',0) > 0 && catalog.getOrDefault('E',0)> 0){
            result = true;
        }
        return result;
    }



    private void calculateSum(){
        sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        Item ItemC = new Item('C');
        Item ItemD = new Item('D');
        sum -= Rule1()*ItemC.getPrice()/2;
        sum -= Rule2()*ItemD.getPrice();
        if(Rule3()){
            sum *= 1.3;
        }
    }

    public double getSum()
    {
        calculateSum();
        return this.sum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Item i : items){
            sb.append(i.toString());
        }
        return sb.toString();
    }
}
