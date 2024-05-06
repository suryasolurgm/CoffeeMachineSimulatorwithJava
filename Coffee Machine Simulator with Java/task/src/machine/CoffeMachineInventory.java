package machine;

public class CoffeMachineInventory {
     static  final int waterPerOneEspresso=250 ;
     static final int coffeeBeansPerOneEspresso=16;
     static final int costOfOneEspresso=4;
    static  final int waterPerOneLatte=350;
    static final int milkPerOneLatte =75;
    static final int coffeeBeansPerOneLatte=20;
    static final int costOfOneLatte=7;

    static  final int waterPerOneCappucino=200;
    static final int milkPerOneCappucion =100;
    static final int coffeeBeansPerOneCappucino=12;
    static final int costOfOneCappucinio=6;

    private int waterAvailable ;
     private int milkAvailable ;
     private int coffeeBeansAvailable ;
     private int disposableCupsAvailable ;
     private int moneyAvailable ;

    public void setCoffeeBeansAvailable(int coffeeBeansAvailable) {
        this.coffeeBeansAvailable = coffeeBeansAvailable;
    }

    public void setMilkAvailable(int milkAvailable) {
        this.milkAvailable = milkAvailable;
    }

    public void setWaterAvailable(int waterAvailable) {
        this.waterAvailable = waterAvailable;
    }

    public void setDisposableCupsAvailable(int disposableCupsAvailable) {
        this.disposableCupsAvailable = disposableCupsAvailable;
    }

    public void setMoneyAvailable(int moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }
    public void addCoffeeBeans(int coffeeBeansAvailable) {
        this.coffeeBeansAvailable+= coffeeBeansAvailable;
    }
    public void addMilk(int milkAvailable) {
        this.milkAvailable+= milkAvailable;
    }
    public void addWater(int waterAvailable) {
        this.waterAvailable += waterAvailable;
    }
    public void addDisposableCups(int disposableCupsAvailable) {
        this.disposableCupsAvailable+= disposableCupsAvailable;
    }
    public int takeMoney() {
        int moneyTaken = moneyAvailable;
        this.moneyAvailable = 0;
        return moneyTaken;
    }
    public int totalCupsofEspressoPossible(int disposableCups ){
        int water = waterAvailable/waterPerOneEspresso;
        int  beans = coffeeBeansAvailable/coffeeBeansPerOneEspresso;
        int cups = disposableCupsAvailable/disposableCups;
        return Math.min(water,Math.min(beans,cups));
    }
    public String dispenseEspresso(){
        if(waterAvailable>=waterPerOneEspresso){
            this.waterAvailable-=waterPerOneEspresso;
        }else{
            return "water";
        }
        if(coffeeBeansAvailable>=coffeeBeansPerOneEspresso){
            this.coffeeBeansAvailable-=coffeeBeansPerOneEspresso;
        }else{
            return "coffee";
        }
        if(disposableCupsAvailable>=1){
            this.disposableCupsAvailable--;
        }else {
            return "disposableCups";
        }
        this.moneyAvailable+=costOfOneEspresso;
        return "true";
    }
    public String dispenseLatte(){
        if(waterAvailable>=waterPerOneLatte){
            this.waterAvailable-=waterPerOneLatte;
        }else {
            return "water";
        }
        if(coffeeBeansAvailable>=coffeeBeansPerOneLatte){
            this.coffeeBeansAvailable-=coffeeBeansPerOneLatte;
        }else {
            return "coffee";
        }
        if(disposableCupsAvailable>=1){
            this.disposableCupsAvailable--;
        }else {
            return "disposableCups";
        }
        if(milkAvailable>=milkPerOneLatte){
            this.milkAvailable-=milkPerOneLatte;
        }else {
            return "milk";
        }

        this.moneyAvailable+=costOfOneLatte;
        return "true";
    }
    public String dispenseCappucino(){
        if (waterAvailable>=waterPerOneCappucino){
            this.waterAvailable-=waterPerOneCappucino;
        }else {
            return "water";
        }
        if (coffeeBeansAvailable>=coffeeBeansPerOneCappucino){
            this.coffeeBeansAvailable-=coffeeBeansPerOneCappucino;
        }else {
            return "coffee";
        }
        if(disposableCupsAvailable>=1){
            this.disposableCupsAvailable--;
        }else {
            return "disposableCups";
        }
        if (milkAvailable>=milkPerOneCappucion){
            this.milkAvailable-=milkPerOneCappucion;
        }else {
            return "milk";
        }
        this.moneyAvailable+=costOfOneCappucinio;
        return "true";
    }
    public void printInventory(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n",this.waterAvailable);
        System.out.printf("%d ml of milk\n",this.milkAvailable);
        System.out.printf("%d of coffee beans\n",this.coffeeBeansAvailable);
        System.out.printf("%d disposable cups\n",this.disposableCupsAvailable);
        System.out.printf("$%d of money\n",this.moneyAvailable);

    }
}
