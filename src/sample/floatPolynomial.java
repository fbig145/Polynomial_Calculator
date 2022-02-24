package sample;

public class floatPolynomial {
    private int degree;
    private float coef;

    public floatPolynomial(int degree, float coef){
        this.degree = degree;
        this.coef = coef;
    }

    public int getDegree(){
        return degree;
    }
    public float getCoef(){
        return coef;
    }
    public void setDegree(int degree){
        this.degree = degree;
    }
    public void setCoef(int coef){
        this.coef = coef;
    }
}
