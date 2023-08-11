public class Item {
    private char name;
    private int price;

    public Item (char c)
    {
        this.name=c;
        switch (c){
            case 'A':
            this.price = 55;
            break; 

            case 'B':
            this.price = 20;
            break;

            case 'C':
            this.price = 60;
            break;

            case 'D':
            this.price = 10;
            break;

            case 'E':
            this.price = 45;
            break;

            default:
            throw new IllegalArgumentException("Nem letezik ilyen termek sajnos: " + name); 
        }  
    }
    public int getPrice(){
        return this.price;
    }
    public char getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.getName() + " termek ara: " + this.getPrice();
    }
}
