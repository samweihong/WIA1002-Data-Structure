import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        try {
            String content = Main.readFile("IOES_Bachok_14093367.03122014.elab");
            List<List<String>> rawTable = Main.toTable(content);

            List<List<Object>> table = processTable(rawTable);
            removeNoise(table, 3);
            convertWindDirection(table);

            List<Object> saturatedVaporPressureList = calculateSaturatedVaporPressure(table);
            appendColumn(table, "Saturated Vapor Pressure", saturatedVaporPressureList);

            Main.displayTable(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<List<Object>> processTable(List<List<String>> rawTable) {
        // change to appropriate indexes accordingly
        int MEASUREMENT_TIME_INDEX = 0;
        int RELATIVE_HUMIDITY_INDEX = 1;
        int AIR_TEMPERATURE_INDEX = 2;
        int ATMOSPHERIC_PRESSURE_INDEX = 3;
        int WIND_SPEED_INDEX = 4;
        int WIND_DIRECTION_INDEX = 5;

        List<List<Object>> table = new ArrayList<>();
        table.add(new ArrayList<>(Arrays.asList("Date/time", "RELHumidity - Ave", "AIRTemp - Ave", "ATMPressure - Ave", "WindSPEED - Ave", "WindDIR - RisDir")));
        for (int i = 1; i < rawTable.size(); i++) {
            List<Object> row = new ArrayList<>();
            row.add(rawTable.get(i).get(MEASUREMENT_TIME_INDEX));
            row.add(Double.parseDouble(rawTable.get(i).get(RELATIVE_HUMIDITY_INDEX)));
            row.add(Double.parseDouble(rawTable.get(i).get(AIR_TEMPERATURE_INDEX)));
            row.add(Double.parseDouble(rawTable.get(i).get(ATMOSPHERIC_PRESSURE_INDEX)));
            row.add(Double.parseDouble(rawTable.get(i).get(WIND_SPEED_INDEX)));
            row.add(Double.parseDouble(rawTable.get(i).get(WIND_DIRECTION_INDEX)));
            table.add(row);
        }
        return table;
    }

    private static void removeNoise(List<List<Object>> table, int windowSize) {
        for (int col = 0; col < table.get(0).size(); col++) {
            List<Number> window = new LinkedList<>();
            for (int row = 1; row < table.size(); row++) {
                if (!(table.get(row).get(col) instanceof Number)) break;
                Number num = (Number) table.get(row).get(col);
                window.add(num.doubleValue());

                if (window.size() < windowSize) {
                    table.get(row).set(col, "N/A");
                    continue;
                }

                table.get(row).set(col, getMedian(window));
                window.removeFirst();
            }
        }
    }

    private static double getMedian(List<? extends Number> nums) {
        List<Number> list = new ArrayList<>(nums);
        list.sort(null);
        int n = nums.size();
        if (n % 2 == 1) {
            return list.get(n / 2).doubleValue();
        } else {
            return (list.get((n - 1) / 2).doubleValue() + list.get(n / 2).doubleValue()) / 2;
        }
    }

    private static void convertWindDirection(List<List<Object>> table) {
        int WIND_DIRECTION_INDEX = 5;
        double[] upperBounds = {
                11.25, 33.75, 56.25, 78.75, 101.25, 123.75, 146.25, 168.75,
                191.25, 213.75, 236.25, 258.75, 281.25, 303.75, 326.25, 348.75
        };
        String[] directions = {
                "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"
        };

        for (int i = 1; i < table.size(); i++) {
            if (!(table.get(i).get(WIND_DIRECTION_INDEX) instanceof Double)) continue;

            double windDirectionDegree = (double) table.get(i).get(WIND_DIRECTION_INDEX);
            String windDirectionCardinal = "N";
            for (int j = 0; j < upperBounds.length; j++) {
                if (windDirectionDegree <= upperBounds[j]) {
                    windDirectionCardinal = directions[j];
                    break;
                }
            }
            table.get(i).set(WIND_DIRECTION_INDEX, windDirectionCardinal);
        }
    }

    private static List<Object> calculateSaturatedVaporPressure(List<List<Object>> table) {
        int AIR_TEMPERATURE_INDEX = 2;
        List<Object> list = new ArrayList<>();
        for (int i = 1; i < table.size(); i++) {
            if (!(table.get(i).get(AIR_TEMPERATURE_INDEX) instanceof Double)) {
                list.add("N/A");
                continue;
            }

            double A;
            double B;
            double C;
            double temperature = (double) table.get(i).get(AIR_TEMPERATURE_INDEX);
            if (1 <= temperature && temperature <= 99) {
                A = 8.07131;
                B = 1730.63;
                C = 233.426;
            } else if (100 <= temperature && temperature <= 374) {
                A = 8.14019;
                B = 1810.94;
                C = 244.485;
            } else {
                list.add("N/A");
                continue;
            }
            double P = Math.pow(10, A - B / (C + temperature + 273.15));
            list.add(P);
        }
        return list;
    }

    private static void appendColumn(List<List<Object>> table, String header, List<?> data) {
        table.get(0).add(header);
        for (int i = 1; i < table.size(); i++) {
            table.get(i).add(data.get(i - 1));
        }
    }
}
