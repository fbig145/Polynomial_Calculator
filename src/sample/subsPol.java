package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class subsPol {
    Polynomial[] pol1 = new Polynomial[100];
    Polynomial[] pol2 = new Polynomial[100];
    Polynomial[] polResult = new Polynomial[100];

    public String resultString = "";

    public void parseAndSub(String firstPol, String secondPol){
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m1 = p.matcher(firstPol);
        Matcher m2 = p.matcher(secondPol);
        int firstPolLength = 0;
        while (m1.find()) {
            pol1[firstPolLength] = new Polynomial(Integer.parseInt(m1.group(2)), Integer.parseInt(m1.group(1)));
            firstPolLength++;
        }
        int secondPolLength = 0;
        while(m2.find()){
            pol2[secondPolLength] = new Polynomial(Integer.parseInt(m2.group(2)), Integer.parseInt(m2.group(1)));
            secondPolLength++;
        }
        IntStream.range(0, firstPolLength).mapToObj(j -> pol1[j].getCoef() + "    " + pol1[j].getDegree()).forEach(System.out::println);
        System.out.println("\n\n");
        IntStream.range(0, secondPolLength).mapToObj(j -> pol2[j].getCoef() + "    " + pol2[j].getDegree()).forEach(System.out::println);
        subFirst(firstPolLength, secondPolLength);
        subSecond(firstPolLength, secondPolLength);
    }
//  3x^2+2x^1+6x^0

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

    public void subFirst(int firstPolLength, int secondPolLength){
        try{
            int polResultLength = 0;
            if(firstPolLength >= secondPolLength){
                int j = 0;
                while (j < firstPolLength) {
                    polResult[polResultLength] = new Polynomial(pol1[j].getDegree(), pol1[j].getCoef());
                    int k = 0;
                    while (k < secondPolLength) {
                        if(pol1[j].getDegree() == pol2[k].getDegree()){
                            polResult[polResultLength].setCoef(pol1[j].getCoef() + (pol2[k].getCoef() * (-1)));
                        }
                        k++;
                    }
                    polResultLength++;
                    j++;
                }
            }else{
                int j = 0;
                while (j < secondPolLength) {
                    polResult[polResultLength] = new Polynomial(pol2[j].getDegree(), pol2[j].getCoef());
                    int k = 0;
                    while (k < firstPolLength) {
                        if(pol2[j].getDegree() == pol1[k].getDegree()){
                            polResult[polResultLength].setCoef(pol2[j].getCoef() + (pol1[k].getCoef() * (-1)));
                        }
                        k++;
                    }
                    polResultLength++;
                    j++;
                }
            }
            System.out.println("\n\n");
            IntStream.range(0, polResultLength).mapToObj(m -> polResult[m].getCoef() + "    " + polResult[m].getDegree()).forEach(System.out::println);
            resultString = "";
            resultString = displayBeautiful(polResultLength);
            System.out.println("\n\n");

            System.out.println(removeLast(resultString));
            resultString = removeLast(resultString);
        }catch(Exception e){
            System.out.println(" ");
        }
    }

    public void subSecond(int firstPolLength, int secondPolLength){
        try {
            int polResultLength = 0;
            int i = 0;
            int j = 0;
            while((i < firstPolLength) || (j < secondPolLength)){
                if(pol1[i].getDegree() > pol2[j].getDegree()){
                    polResult[polResultLength] = new Polynomial(pol1[i].getDegree(), pol1[i].getCoef());
                    i++;
                    polResultLength++;
                }else if(pol1[i].getDegree() < pol2[j].getDegree()){
                    polResult[polResultLength] = new Polynomial(pol2[j].getDegree(), pol2[j].getCoef());
                    j++;
                    polResultLength++;
                }else{
                    polResult[polResultLength] = new Polynomial(pol2[j].getDegree(), pol2[j].getCoef() + (pol1[i].getCoef() * (-1)));
                    j++;
                    i++;
                    polResultLength++;
                }
            }
            System.out.println("\n\n");
            IntStream.range(0, polResultLength).mapToObj(m -> polResult[m].getCoef() + "    " + polResult[m].getDegree()).forEach(System.out::println);
            resultString = "";
            resultString = displayBeautiful(polResultLength);
            System.out.println("\n\n");
            System.out.println(removeLast(resultString));
            resultString = removeLast(resultString);
        }catch (Exception e){
            System.out.println(" ");
        }
    }
}
