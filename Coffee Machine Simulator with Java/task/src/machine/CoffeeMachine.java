package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            CoffeMachineInventory machineInventory = new CoffeMachineInventory();
            machineInventory.setCoffeeBeansAvailable(120);
            machineInventory.setWaterAvailable(400);
            machineInventory.setMilkAvailable(540);
            machineInventory.setDisposableCupsAvailable(9);
            machineInventory.setMoneyAvailable(550);
            boolean isEnd = true;
            while (isEnd) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String action = scanner.nextLine();
                switch (action) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        String choiceString = scanner.nextLine();
                        if (choiceString.equals("back")) {
                            break;
                        }
                        int choice = Integer.parseInt(choiceString);
                        switch (choice) {
                            case 1:
                                String espresso = machineInventory.dispenseEspresso();
                                if(espresso.equals("true")){
                                    System.out.println("I have enough resources, making you a coffee!");
                                }else {
                                    System.out.printf("Sorry, not enough %s!\n",espresso);
                                }
                                break;
                            case 2:
                                String latte = machineInventory.dispenseLatte();
                                if(latte.equals("true")){
                                    System.out.println("I have enough resources, making you a coffee!");
                                }else {
                                    System.out.printf("Sorry, not enough %s!\n",latte);
                                }
                                break;
                            case 3:
                                String cappucino = machineInventory.dispenseCappucino();
                                if(cappucino.equals("true")){
                                    System.out.println("I have enough resources, making you a coffee!");
                                }else {
                                    System.out.printf("Sorry, not enough %s!\n",cappucino);
                                }
                                break;
                        }
                        break;
                    case "fill":
                        System.out.println("Write how many ml of water you want to add: ");
                        int water = scanner.nextInt();
                        machineInventory.addWater(water);
                        System.out.println("Write how many ml of milk you want to add: ");
                        int milk = scanner.nextInt();
                        machineInventory.addMilk(milk);
                        System.out.println("Write how many grams of coffee beans you want to add: ");
                        int coffeeBeans = scanner.nextInt();
                        machineInventory.addCoffeeBeans(coffeeBeans);
                        System.out.println("Write how many disposable cups you want to add: ");
                        int disposableCups = scanner.nextInt();
                        machineInventory.addDisposableCups(disposableCups);
                        scanner.nextLine();
                        break;
                    case "take":
                        System.out.printf("I gave you $%d\n",machineInventory.takeMoney());
                        break;
                    case "remaining":
                        machineInventory.printInventory();
                        break;
                    case "exit":
                        isEnd=false;
                        break;
                }
            }

    }
}
