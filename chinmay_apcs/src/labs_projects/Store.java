package labs_projects;

/**
 * Store.java - Unit 5 lab 
 *
 * @author - Kathy Chang
 * @date - 11/2021
 * 
 * This Store class is to utilize TeddyBearInventory class.
 * It simulates a store to buy/sell teddy bears.
 */ 
public class Store
{
    public static void main(String[] args)
    {

        // 1. Use 1st consturctor to create a teddy bear object for small bears. 
        // 2. Then add 10 teddy bears to inventory.
        // 3. Each costs $10 and will be sold at $15.
        TeddyBearInventory smallBear = new TeddyBearInventory("small");
        smallBear.setCost(10.0);
        smallBear.setPrice(15.0);
        smallBear.addBear(10);
        
        // 4. Use 2nd constructor to create a teddy bear object for large bears. 
        //    There are 10 bears and each costs $20 and the sale price is $30.
        TeddyBearInventory largeBear = new TeddyBearInventory("large", 10, 15.0, 25.0);
        
        // 5. Print current inventory status. 
        showInventory(smallBear, largeBear);

        // 6. Sell 8 small bears.
        sellBear(smallBear, 8);

        // 7. Sell 5 large bears.
        sellBear(largeBear, 5);

        // 8. Sell 5 more small bears.  This should fail.
        sellBear(smallBear, 5);

        // 9. Print current inventory status to double check.
        showInventory(smallBear, largeBear);

        //10. Get more teddy bears. 10 small at $12 each and set the price to $20.
        smallBear.setCost(12.0);
        smallBear.setPrice(20.0);
        smallBear.addBear(10);
        System.out.println("Buy 10 small bears at $" + smallBear.getCost() +
           ". New price at $" + smallBear.getPrice() + ".\n");

        //11. Buy 5 large at $20 each and set the price to $350
        largeBear.setCost(20.0);
        largeBear.setPrice(30.0);
        largeBear.addBear(5);
        System.out.println("Buy 5 large bears at $" + largeBear.getCost() +
           ". New price at $" + largeBear.getPrice() + ".\n");

        //12. Print current inventory status. 
        showInventory(smallBear, largeBear);
        
        //13. Sell 5 small bears, 
        sellBear(smallBear, 5);

        //14. Sell 5 large bears.
        sellBear(largeBear, 5);

        //15. Print current inventory status. 
        showInventory(smallBear, largeBear);

    }

    /** showInventory(TeddyBearInventory, TeddyBearInventory)
     *  print current inventory and cost/profit for teddybears
     * 
     *  Example:
     *  Inventory:
     *  7 small teddy bears. Cost: 12.0. Price: 20.0.
     *  5 large teddy bears. Cost: 20.0. Price: 30.0.
     *  Total 12 teddy bears in stock now. Total cost: $470.0. Total profit: $495.0.
     */
    public static void showInventory(TeddyBearInventory smallBear, TeddyBearInventory largeBear)
    {
        System.out.println("Inventory:");
        System.out.println(smallBear);
        System.out.println(largeBear);
        System.out.println("Total " + TeddyBearInventory.getTotalCount() + 
            " teddy bears in stock now. Total cost: $" +
            TeddyBearInventory.getTotalCost() +
            ". Total profit: $" + TeddyBearInventory.getTotalProfit() + ".");
        System.out.println();          
    }

    /** sellBear(TeddyBearInventory bear, int count)
     *  call bear's sellBear method
     */
    public static void sellBear(TeddyBearInventory bear, int count)
    {
        if (bear.sellBear(count))
        {
            // print message "Sell x size bears at $x."
            System.out.println("Sell " + count + " " + bear.getSize() + " bears at $" + 
            bear.getPrice() + ".");
        }
        else
        {
            System.out.println("You only have " + bear.getCount() + " " + bear.getSize() + " bears in stock.");
        }
        System.out.println();          
    }
}
