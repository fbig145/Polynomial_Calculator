package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class derivative {
    Polynomial[] pol1 = new Polynomial[100];
    Polynomial[] polResult = new Polynomial[100];

    public String resultString = "";

    public void parseAndDerivate(String firstPol) {
        Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m1 = p.matcher(firstPol);
        int firstPolLength = 0;
        while (m1.find()) {
            pol1[firstPolLength] = new Polynomial(Integer.parseInt(m1.group(2)), Integer.parseInt(m1.group(1)));
            firstPolLength++;
        }
        int polResultLength = 0;
        int i = 0;
        while (i < firstPolLength) {
                polResult[polResultLength] = new Polynomial(pol1[i].getDegree() - 1, pol1[i].getDegree() * pol1[i].getCoef());
                polResultLength++;
            i++;
        }
        IntStream.range(0, polResultLength).mapToObj(m -> polResult[m].getCoef() + "    " + polResult[m].getDegree()).forEach(System.out::println);
        resultString = "";
        resultString = displayBeautiful(polResultLength);
        System.out.println("\n\n");
        System.out.println(removeLast(resultString));
        resultString = removeLast(resultString);
    }
    public String removeLast(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == '+') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public String displayBeautiful(int polResultLength){
        String resultString2 = "";
        int m = 0;
        while (m < polResultLength-1) {
            if(polResult[m+1].getCoef() < 0){
                resultString2 = resultString2 + (polResult[m].getCoef() + "x^" + polResult[m].getDegree());
            }else{
                resultString2 = resultString2 + (polResult[m].getCoef() + "x^" + polResult[m].getDegree()) + "+";
            }
            m++;
        }
        if(polResult[polResultLength-1].getCoef() < 0){
            resultString2 = resultString2 + (polResult[polResultLength-1].getCoef() + "x^" + polResult[polResultLength-1].getDegree());
        }else{
            resultString2 = resultString2 + (polResult[polResultLength-1].getCoef() + "x^" + polResult[polResultLength-1].getDegree()) + "+";
        }
        return resultString2;
    }
}
