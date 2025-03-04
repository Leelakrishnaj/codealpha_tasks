import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StockTradingPlatform
{
    static class Stock
    {
        String ticker;
        double price;

        public Stock(String ticker, double price)
        {
            this.ticker = ticker;
            this.price = price;
        }
    }

    static class Portfolio
    {
        Map<String, Integer> holdings = new HashMap<>();
        double balance;

        public Portfolio(double balance)
        {
            this.balance = balance;
        }

        public void buyStock(String ticker, int quantity, double price)
        {
            double cost = quantity * price;
            if (balance >= cost)
            {
                holdings.put(ticker, holdings.getOrDefault(ticker, 0) + quantity);
                balance -= cost;
                System.out.println("Bought " + quantity + " shares of " + ticker + " at " + price + " each.");
            }
            else
            {
                System.out.println("Insufficient funds to buy " + quantity + " shares of " + ticker);
            }
        }

        public void sellStock(String ticker, int quantity, double price)
        {
            int owned = holdings.getOrDefault(ticker, 0);
            if (owned >= quantity)
            {
                holdings.put(ticker, owned - quantity);
                balance += quantity * price;
                System.out.println("Sold " + quantity + " shares of " + ticker + " at " + price + " each.");
            }
            else
            {
                System.out.println("You don't own enough shares of " + ticker + " to sell.");
            }
        }

        public void displayPortfolio()
        {
            System.out.println("\nPortfolio Summary:");
            for (String ticker : holdings.keySet())
            {
                System.out.println("Stock: " + ticker + ", Shares Owned: " + holdings.get(ticker));
            }
            System.out.println("Balance: $" + balance);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        Stock stockA = new Stock("AAPL", 150.00);
        Stock stockB = new Stock("GOOG", 2800.00);
        Stock stockC = new Stock("AMZN", 3400.00);

        
        Portfolio portfolio = new Portfolio(10000.00);

        while (true)
        {
            
            System.out.println("\nWelcome to the Stock Trading Platform!");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                   
                    System.out.println("\nMarket Data:");
                    System.out.println("AAPL: $" + stockA.price);
                    System.out.println("GOOG: $" + stockB.price);
                    System.out.println("AMZN: $" + stockC.price);
                    break;

                case 2:
                    
                    System.out.print("Enter stock ticker (AAPL, GOOG, AMZN): ");
                    String buyTicker = sc.next().toUpperCase();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = sc.nextInt();

                    if (buyTicker.equals("AAPL"))
                    {
                        portfolio.buyStock(buyTicker, buyQuantity, stockA.price);
                    }
                    else if (buyTicker.equals("GOOG"))
                    {
                        portfolio.buyStock(buyTicker, buyQuantity, stockB.price);
                    }
                    else if (buyTicker.equals("AMZN"))
                    {
                        portfolio.buyStock(buyTicker, buyQuantity, stockC.price);
                    }
                    else
                    {
                        System.out.println("Invalid ticker.");
                    }
                    break;

                case 3:
                   
                    System.out.print("Enter stock ticker (AAPL, GOOG, AMZN): ");
                    String sellTicker = sc.next().toUpperCase();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = sc.nextInt();

                    if (sellTicker.equals("AAPL"))
                    {
                        portfolio.sellStock(sellTicker, sellQuantity, stockA.price);
                    }
                    else if (sellTicker.equals("GOOG"))
                    {
                        portfolio.sellStock(sellTicker, sellQuantity, stockB.price);
                    }
                    else if (sellTicker.equals("AMZN"))
                    {
                        portfolio.sellStock(sellTicker, sellQuantity, stockC.price);
                    }
                    else
                    {
                        System.out.println("Invalid ticker.");
                    }
                    break;

                case 4:
                    
                    portfolio.displayPortfolio();
                    break;

                case 5:
                    
                    System.out.println("Thank you for using the platform!");
                    sc.close();
                    return;

                default:
                   
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
