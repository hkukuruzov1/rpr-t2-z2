package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna,krajnja;
    private boolean pocetniInterval,krajnjiInterval;

    public double getPocetna() {
        return pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public boolean isPocetniInterval() {
        return pocetniInterval;
    }

    public boolean isKrajnjiInterval() {
        return krajnjiInterval;
    }

    Interval(double a, double b, boolean c, boolean d){
if(a>b)
    throw new IllegalArgumentException();
pocetna=a;
krajnja=b;
pocetniInterval=c;
krajnjiInterval=d;
}
Interval(){
    pocetna=0;
    krajnja=0;
    pocetniInterval=false;
    krajnjiInterval=false;
}
public boolean isNull(){
    if(pocetna==0 && krajnja==0)
        return  true;
    return false;
}
    public boolean isIn(double a){
    if((a>pocetna && a<krajnja) || (a==pocetna && pocetniInterval) ||(a==krajnja && krajnjiInterval))
        return  true;
    return false;
    }
    public Interval intersect(Interval v1){
        return new Interval(Double.min(v1.getPocetna(), this.getKrajnja()),Double.min(v1.getKrajnja(),this.getKrajnja()),true,true);
    }
    public static Interval intersect(Interval v1,Interval v2){
        return new Interval(Double.min(v1.getPocetna(), v2.getKrajnja()),Double.min(v1.getKrajnja(),v2.getKrajnja()),true,true);
    }
}
