package com.example.second;

import android.widget.TextView;

public class CalcController {
    Double A;
    Double B;
    Operaciia oper;
    NumberController nc;

    public void setNc(NumberController nc) {
        this.nc = nc;
    }

    public void slojit(){
        if(oper != null) {
            vychislit();
        }
        if (!nc.getError()) {
            A = nc.getValue();
            oper = Operaciia.SLOJENIE;
            nc.clear();
        }
    }

    public void vychest(){
        if(oper != null) {
            vychislit();
        }
        if (!nc.getError()) {
            A = nc.getValue();
            oper = Operaciia.VYCHITANIE;
            nc.clear();
        }
    }

    public void umnojit(){
        if(oper != null) {
            vychislit();
        }
        if (!nc.getError()) {
            A = nc.getValue();
            oper = Operaciia.UMNOJENIE;
            nc.clear();
        }
    }

    public void delit(){
        if(oper != null) {
            vychislit();
        }
        if (!nc.getError()) {
            A = nc.getValue();
            oper = Operaciia.DELENIE;
            nc.clear();
        }
    }

    public void vychislit(){
        B = nc.getValue();
        nc.clear();
        if (oper == Operaciia.SLOJENIE){
            oper = null;
            Double R = A+B;
            nc.setResult(R);
        }
        if (oper == Operaciia.VYCHITANIE){
            oper = null;
            Double R = A-B;
            nc.setResult(R);
        }
        if (oper == Operaciia.UMNOJENIE){
            oper = null;
            Double R = A*B;
            nc.setResult(R);
        }
        if (oper == Operaciia.DELENIE){
            oper = null;
            try {
                Double R = A / B;
                nc.setResult(R);
            }catch(Exception e){
                nc.setError();
            }
        }
    }

}
