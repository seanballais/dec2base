class Core
{
    private String[] valueMapping = {
        "0", "1", "2", "3",
        "4", "5", "6", "7",
        "8", "9", "A", "B",
        "C", "D", "E", "F"
    };

    private String wholeToBase(int whole, int base)
    {
        String output = "";
        int remainder = 0;
        while (whole != 0) {
            remainder = whole % base;
            whole /= base;
            output = valueMapping[remainder] + output;
        }

        return output;
    }

    private String fractionalToBase(double fractional, int base, int numPlaces)
    {
        String output = "";
        int characteristic = 0;
        int limit = 0;
        while (fractional != 0f && limit < numPlaces) {
            characteristic = (int) (fractional * base);
            fractional *= base;
            fractional -= characteristic;
            output += valueMapping[characteristic];

            limit++;
        }

        return output;
    }

    private int countOccurences(String src, char target)
    {
        int count = 0;
        for (char ch : src.toCharArray()) {
            if (ch == target) {
                count++;
            }
        }

        return count;
    }

    public String decimalToBase(String decimal, int base, int numPlaces)
    {
        // Data validation
        String errorMessage = "Error:";
        if (decimal.length() <= 0) {
            errorMessage += " No input given.";
        }

        if (countOccurences(decimal, '.') > 1) {
            errorMessage += " Decimal contains more than one decimal point.";
        }

        if (!decimal.matches("[0-9.]+")) {
            errorMessage += " Input contains letters and symbols (excluding decimal point).";
        }

        if (errorMessage.length() > 6) {
            // Errors are present in the input.
            return errorMessage;
        }

        String numbers[] = decimal.split("\\.");

        int whole = Integer.parseInt(numbers[0]);

        int places = numbers[1].length();
        double fractional = Integer.parseInt(numbers[1]) / Math.pow(10, places);

        return wholeToBase(whole, base) + "." + fractionalToBase(fractional, base, numPlaces);
    }

    public static void main(String[] args)
    {
        Core c = new Core();
        System.out.println(c.decimalToBase("6.9", 2, 10));
    }
}
