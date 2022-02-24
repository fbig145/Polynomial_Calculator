package sample;

public class Polynomial {
        private int degree;
        private int coef;

        public Polynomial(int degree, int coef){
            this.degree = degree;
            this.coef = coef;
        }

        public int getDegree(){
            return degree;
        }
        public int getCoef(){
            return coef;
        }
        public void setDegree(int degree){
            this.degree = degree;
        }
        public void setCoef(int coef){
            this.coef = coef;
        }

}
