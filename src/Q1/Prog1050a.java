package Q1;

import java.io.*;
import java.util.*;
import java.text.*;

class SalesRecord {
    String[] fields;
    public SalesRecord(String[] data) { fields = data; }
    public double getProfit() { return Double.parseDouble(fields[13]); }
    public double getUnitsSold() { return Double.parseDouble(fields[8]); }

}
// Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,
// Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit
public class Prog1050a {
    private static double totalProfitLoss = 0;
    public static List<SalesRecord> loadSalesData(String filepath) {
        var records = new ArrayList<SalesRecord>();
        try {
            var file = new Scanner(new File(filepath));
            file.nextLine(); // Skip header line
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] data = line.split(",");
                records.add(new SalesRecord(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return records;
    }

    public static void main(String[] args) {
        var records = loadSalesData("Langdat/Lang1050.csv");
        if (records != null) {
            var moneyFormat = new DecimalFormat("$#,###.00");
            System.out.println("Sales to Europe: " + computeCount(records, 0, "Europe"));
            System.out.println("Cereal bought by Cambodia: " +
                    computeUnitsSold(records, 1, "Cambodia", 2, "Cereal"));
            System.out.println("Total profit on Meat: " +
                    moneyFormat.format(computeSum(records, 2, "Meat", 13)));
            System.out.println("High priority sales percentage: " +
                    computePercentage(records, 4, "H") + "%");
            System.out.println("Fruits profit lost in 2012: " +
                    moneyFormat.format(computeProfitLostIn2012(records, "Fruits")));
            System.out.println("High priority sales shipped more than 3 days late: " +
                    computeHighPriorityLateSales(records));
            System.out.println("Country with highest profit on Personal Care items: " +
                    computeHighestProfit(records, 2, "Personal Care"));
            System.out.println("Region that bought the most Snacks: " +
                    computeMaxByField(records, 2, "Snacks", 0));
            System.out.println("Records of sales to African nations: " +
                    computeCount(records, 0, "Sub-Saharan Africa"));
            deleteCountryOrders(records, 1, "Kuwait");
            limitCountrySales(records, 1, 8, "Uganda", 100, "Cosmetics");
            deleteCountryOrdersPriority(records, 1, 4, "Sub-saharan Africa", "L");
            System.out.printf("Total profit loss: $%.2f", totalProfitLoss);
            // TODO: the rest
        }
    }

    public static int computeCount(List<SalesRecord> records, int fIndex, String value) {
        int count = 0;
        for (var record : records) if (record.fields[fIndex].equalsIgnoreCase(value)) count++;
        return count;
    }

    public static int computeCount(List<SalesRecord> records, int fIndex1, String value1,
                                                              int fIndex2, String value2) {
        int count = 0;
        for (var record : records) if (record.fields[fIndex1].equalsIgnoreCase(value1) &&
                                       record.fields[fIndex2].equalsIgnoreCase(value2)) count++;
        return count;
    }

    public static double computePercentage(List<SalesRecord> records, int fIndex, String value) {
        return ((double) computeCount(records, fIndex, value) / records.size()) * 100;
    }

    public static int computeUnitsSold(List<SalesRecord> records, int fIndex1, String value1,
                                                                  int fIndex2, String value2) {
        int total = 0;
        for (var record : records) if (record.fields[fIndex1].equalsIgnoreCase(value1) &&
                record.fields[fIndex2].equalsIgnoreCase(value2)) total += record.getUnitsSold();
        return total;
    }

    public static double computeSum(List<SalesRecord> records, int fIndex, String value, int sumFIndex) {
        double sum = 0;
        for (var record : records)
            if (record.fields[fIndex].equalsIgnoreCase(value))
                sum += Double.parseDouble(record.fields[sumFIndex]);
        return sum;
    }

    public static double computeProfitLostIn2012(List<SalesRecord> records, String itemType) {
        double lostProfit = 0;
        for (var record : records)
            if (record.fields[2].equalsIgnoreCase(itemType) &&
                record.fields[5].endsWith("2012"))
                lostProfit += Double.parseDouble(record.fields[13]);
        return lostProfit;
    }

    public static int computeHighPriorityLateSales(List<SalesRecord> records) {
        int count = 0;
        var dateFormat = new SimpleDateFormat("M/d/yyyy");
        for (var record : records) {
            if (record.fields[4].equalsIgnoreCase("H")) {
                try {
                    Date orderDate = dateFormat.parse(record.fields[5]);
                    Date shipDate = dateFormat.parse(record.fields[7]);

                    // Calculate the difference in days between order/ship dates
                    long diffInMs = Math.abs(shipDate.getTime() - orderDate.getTime());
                    long diffInDays = diffInMs / (1000 * 60 * 60 * 24);

                    if (diffInDays > 3) count++;

                } catch (ParseException e) { e.printStackTrace(); }
            }
        }
        return count;
    }

    public static String computeHighestProfit(List<SalesRecord> records, int fIndex, String value) {
        String highestCountry = "N/A";
        double highestProfit = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                double profit = Double.parseDouble(record.fields[13]);
                if (profit > highestProfit) {
                    highestProfit = profit;
                    highestCountry = record.fields[1];
                }
            }
        }

        return highestCountry;
    }

    public static String computeMaxByField(List<SalesRecord> records, int fIndex,
                                          String itemType, int resultFIndex) {
        String topRegion = "N/A";
        int maxCount = 0;
        var regions = new ArrayList<String>();

        // Get a list of all the unique regions in the dataset
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                String region = record.fields[resultFIndex];
                if (!regions.contains(region)) regions.add(region);
            }
        }

        // Count occurrences of each unique region
        for (var region : regions) {
            int count = computeCount(records, fIndex, itemType, resultFIndex, region);
//            int count = 0;
//            for (var record : records)
//                if (record.fields[fIndex].equalsIgnoreCase(itemType) &&
//                record.fields[resultfIndex].equalsIgnoreCase(region))
//                    count++;
            if (count > maxCount) {
                maxCount = count;
                topRegion = region;
            }
        }

        return topRegion;
    }

    public static void deleteCountryOrders(List<SalesRecord> records, int fIndex, String country) {
        for (int lcv = 0; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[fIndex].equalsIgnoreCase(country)) {
                totalProfitLoss += Double.parseDouble(records.get(lcv).fields[13]);
                records.remove(lcv);
                lcv--;
            }
        }
    }

    public static void limitCountrySales(List<SalesRecord> records, int fIndex, int fIndex2,
                                         String country, int limit, String item) {
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(country)) {
                int lostSales = Integer.parseInt(record.fields[fIndex2]) - 100;
                record.fields[fIndex2] = String.valueOf(limit);

                double lostCost = lostSales * Double.parseDouble(record.fields[10]);
                double lostRevenue = lostSales * Double.parseDouble(record.fields[9]);
                double lostProfit = lostRevenue - lostCost;

                record.fields[11] = String.valueOf(lostRevenue);
                record.fields[12] = String.valueOf(lostCost);
                record.fields[13] = String.valueOf(lostProfit);

                totalProfitLoss += lostProfit;
            }
        }
    }

    public static void deleteCountryOrdersPriority(List<SalesRecord> records, int fIndex, int fIndex2, String country, String priority) {
        for (int lcv = 0; lcv < records.size(); lcv++) {
            if (records.get(lcv).fields[fIndex].equalsIgnoreCase(country)) {
                if (records.get(lcv).fields[fIndex2].equalsIgnoreCase(priority)) {
                    totalProfitLoss += Double.parseDouble(records.get(lcv).fields[13]);
                    records.remove(lcv);
                    lcv--;
                }
            }
        }
    }

}
/*
Sales to Europe: 129286
Cereal bought by Cambodia: 1164596
Total profit on Meat: $11,933,838,488.00
High priority sales percentage: 24.9974%
Fruits profit lost in 2012: $67,345,418.37
High priority sales shipped more than 3 days late: 115166
Country with highest profit on Personal Care items: Iceland
Region that bought the most Snacks: Sub-Saharan Africa
Records of sales to African nations: 130422
Total profit loss: $2104769573.92
 */