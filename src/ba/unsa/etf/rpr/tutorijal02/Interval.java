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
        if(this.getPocetna()<v1.getPocetna()){
            if(this.getKrajnja()<v1.getPocetna())
                return new Interval(0,0,false,false);
        }
        else{
            if(v1.getKrajnja()<this.getPocetna())
                return new Interval(0,0,false,false);
        }
        double a=Double.max(v1.getPocetna(), this.getPocetna());
        double b=Double.min(v1.getKrajnja(), this.getKrajnja());
        boolean c,d;
        if(v1.getPocetna()==a)
            c=v1.isPocetniInterval();
        else
            c=this.isPocetniInterval();
        if(v1.getKrajnja()==b)
            d=v1.isKrajnjiInterval();
        else
            d=this.isKrajnjiInterval();
        return new Interval(a, b,c,d);
    }
    public static Interval intersect(Interval v1,Interval v2){
        if(v2.getPocetna()<v1.getPocetna()){
            if(v2.getKrajnja()<v1.getPocetna())
                return new Interval(0,0,false,false);
        }
        else{
            if(v1.getKrajnja()<v2.getPocetna())
                return new Interval(0,0,false,false);
        }
        double a=Double.max(v1.getPocetna(), v2.getPocetna());
        double b=Double.min(v1.getKrajnja(), v2.getKrajnja());
        boolean c,d;
        if(v1.getPocetna()==a)
            c=v1.isPocetniInterval();
        else
            c=v2.isPocetniInterval();
        if(v1.getKrajnja()==b)
            d=v1.isKrajnjiInterval();
        else
            d=v2.isKrajnjiInterval();
        return new Interval(a,b,c,d);
    }
    public String toString(){
        if(this.isNull())
            return "("+")";
        else if(this.isKrajnjiInterval() && this.isPocetniInterval())
            return "["+this.getPocetna()+","+this.getKrajnja()+"]";
        else if(this.isKrajnjiInterval() && this.isPocetniInterval()==false)
            return "("+this.getPocetna()+","+this.getKrajnja()+"]";
            else if(this.isKrajnjiInterval()==false && this.isPocetniInterval())
            return "["+this.getPocetna()+","+this.getKrajnja()+")";
        return "("+this.getPocetna()+","+this.getKrajnja()+")";

    }
    public boolean equals( Interval f){
        return this.getPocetna()==f.getPocetna() && this.getKrajnja()==f.getKrajnja() &&
                f.isKrajnjiInterval()==this.isKrajnjiInterval() && f.isPocetniInterval()==this.isPocetniInterval();
    }
}
