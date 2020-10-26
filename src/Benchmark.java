import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Benchmark {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {

        String line = "Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10";
            Benchmark.matchBenchmark(line);
    }

    public static void matchBenchmark(String input) {
        String[] parts = input.split(":");
        String[] porfolioParts = parts[0].split("\\|");
        String[] benchmarkParts = parts[1].split("\\|");
        Asset portfolio = new Asset();
        Asset benchmark = new Asset();
        for(String p :porfolioParts){
            String[] tempArray = p.split(",");
            portfolio.add(tempArray[1], tempArray[0], Integer.parseInt(tempArray[2]));
        }
        for(String p :benchmarkParts){
            String[] tempArray = p.split(",");
            benchmark.add(tempArray[1], tempArray[0], Integer.parseInt(tempArray[2]));
        }

        MatchingCalculator matcher = new MatchingCalculator(portfolio,benchmark);
        matcher.calculate();


    }

}
class Asset{
    HashMap<String, Integer> stocks;
    HashMap<String, Integer> bonds;

    public Asset(){
        stocks = new HashMap<String, Integer>();
        bonds = new HashMap<String, Integer>();
    }

    public void addStock(String company, int share){
        stocks.put(company,share);
    }

    public void addBond(String company, int share){
        bonds.put(company,share);
    }
    public void add(String type, String company, int share){
        if(type.equals("STOCK")){
            addStock(company,share);
        }else{
            addBond(company,share);
        }
    }

    public boolean checkStock(String company){
        return stocks.containsKey(company);
    }
    public boolean checkBond(String company){
        return bonds.containsKey(company);
    }

    public void printAsset(){
        for (String i : stocks.keySet()) {
            System.out.println( i + " Stock: " + stocks.get(i));
        }
        for (String i : bonds.keySet()) {
            System.out.println( i + " Stock: " + bonds.get(i));
        }
    }
}

class Transaction{
    String company;
    String assetType;
    String action;
    int share;
    public Transaction(String company,String assetType,String action,int share){
        this.company = company;
        this.assetType = assetType;
        this.action = action;
        this.share = share;
    }
}
class MatchingCalculator{
    Asset portfolio;
    Asset benchmark;
    List<Transaction> transactions;
    public MatchingCalculator(Asset port,Asset bench){
        portfolio = port;
        benchmark = bench;
        transactions = new ArrayList<Transaction>();
    }

    public void calculate() {
        calculateStock();
        calculateBond();
        sortTransactions();
        printResults();
    }

    private void calculateStock() {
        checkProtfolioStock();
        checkBenchStock();
    }

    private void checkBenchStock() {
        for (String i : benchmark.stocks.keySet()) {
            if (!portfolio.checkStock(i)) {
                Transaction trans = new Transaction(i, "STOCK", "BUY", benchmark.stocks.get(i));
                transactions.add(trans);
            }
        }
    }

    private void checkProtfolioStock() {
        for (String i : portfolio.stocks.keySet()) {
//            if the asset does not exit in benchmark, sell all
            if (!benchmark.checkStock(i)) {
                Transaction trans = new Transaction(i, "STOCK", "SELL", benchmark.stocks.get(i));
                transactions.add(trans);
            }
//            if the asset does exist
            int pValue = portfolio.stocks.get(i);
            int bValue = benchmark.stocks.get(i);
            int diff = bValue - pValue;
            if (diff > 0) {
                Transaction trans = new Transaction(i, "STOCK", "BUY", diff);
                transactions.add(trans);
            } else if (diff < 0) {
                Transaction trans = new Transaction(i, "STOCK", "SELL", -diff);
                transactions.add(trans);
            }
        }
    }

    private void calculateBond() {
        checkProtfolioBond();
        checkBenchBond();
    }

    private void checkBenchBond() {
        for (String i : benchmark.bonds.keySet()) {
            if (!portfolio.checkBond(i)) {
                Transaction trans = new Transaction(i, "BOND", "BUY", benchmark.bonds.get(i));
                transactions.add(trans);
            }
        }
    }

    private void checkProtfolioBond() {
        for (String i : portfolio.bonds.keySet()) {
            if (!benchmark.checkBond(i)) {
                Transaction trans = new Transaction(i, "BOND", "SELL", benchmark.bonds.get(i));
                transactions.add(trans);
            }
//            if the asset does exist
            int pValue = portfolio.bonds.get(i);
            int bValue = benchmark.bonds.get(i);
            int diff = bValue - pValue;
            if (diff > 0) {
                Transaction trans = new Transaction(i, "BOND", "BUY", diff);
                transactions.add(trans);
            } else if (diff < 0) {
                Transaction trans = new Transaction(i, "BOND", "SELL", -diff);
                transactions.add(trans);
            }
        }
    }

    private void sortTransactions() {
        Collections.sort(transactions, new Comparator<Transaction>() {

            @Override
            public int compare(Transaction o1, Transaction o2) {
                int flag;
                flag = o1.company.compareTo(o2.company);
                if (flag == 0) {
                    flag = o1.assetType.compareTo(o2.assetType);
                }
                return flag;
            }
        });
    }
    private void printResults() {
        for(Transaction s : transactions){
            System.out.println(s.action+", "+s.company+", "+s.assetType+", "+s.share);
        }
    }

}