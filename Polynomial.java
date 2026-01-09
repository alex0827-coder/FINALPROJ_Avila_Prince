public class Polynomial {

    private String function;

    public Polynomial(String function) {
// remove unnecessary spaces
        this.function = function.replace(" ", "");
    }
//public method to calculate a simple polynomial derivative
    public String getDerivative() {

//result holder as the polynomial gets derived
        String result = "";

        // separates the polynomial term by term using (+-) in every - sign
        String processed = function.replace("-", "+-");

        // splits the polynomial into individual terms
        String[] terms = processed.split("\\+");
        for (String term : terms) {
            if (term.isEmpty()) continue;

            double coefficient;
            int exponent;

            if (term.contains("x")) {
    
// coefficient modificator part
                // splits each term with respect to x using array
                String coeffPart = term.split("x")[0];
                // recognizes a coefficient and assigns 1 value if the coefficient next to x is empty
                if (coeffPart.equals("") || coeffPart.equals(
                    "+")) {
                    coefficient = 1;
                // recognizes -1 value if the coefficient next to x is just a minus sign
                } else if (coeffPart.equals("-")) {
                    coefficient = -1;
                } else {
                //inputs the actual coefficient value
                    coefficient = Double.parseDouble(coeffPart);
                }

// Exponent modificator part
                // checks if the term has an exponent by recognizing the symbol "^"
                if (term.contains("^")) {
                // splits  the term using arrays if the symbol "^" is present and applies the exponent value
                    exponent = Integer.parseInt(term.split("\\^")[1]);
                } else {
                // assigns exponent value of 1 if there is no "^" symbol
                    exponent = 1;
                }
                
// derivative calculation part
                // Apply derivative rule: d/dx [a*x^n] = a*n*x^(n-1)
                double newCoeff = coefficient * exponent;
                int newExp = exponent - 1;

                // Formatting: add "+" or "-" depending on sign
                if (!result.isEmpty() && newCoeff > 0) {
                    result += " + ";
                } else if (newCoeff < 0) {
                    result += " ";
                }

                // Append coefficient (note: prints negative directly)
                result += newCoeff;

                // If exponent > 0, append "x"
                if (newExp > 0) {
                    result += "x";
                    // If exponent > 1, append "^exp"
                    if (newExp > 1) {
                        result += "^" + newExp;
                    }
                }
            }
            // Constants disappear in derivative (ignored)
        }

        // Return the final derivative string
        return result;
    }
}
