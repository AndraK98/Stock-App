package com.example.andrijakolacek2018202186;

public class StockModel {

    private String c,h,l,ch,cp,t,s,cty,ccy,exch,id,tm;

    public StockModel(String c, String h, String l, String ch, String cp, String t, String s, String cty, String ccy, String exch, String id, String tm) {
        this.c = c;
        this.h = h;
        this.l = l;
        this.ch = ch;
        this.cp = cp;
        this.t = t;
        this.s = s;
        this.cty = cty;
        this.ccy = ccy;
        this.exch = exch;
        this.id = id;
        this.tm = tm;
    }

    public StockModel() {
    }

    @Override
    public String toString() {
        return s + "\n" + "Last Price   " + l + "\n" +
                "Currency  " + ccy + "\n" +
                "24h Change   " + ch + "% \n" +
                "Exchange   " + exch + "\n" +
                "Time   " + tm;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getExch() {
        return exch;
    }

    public void setExch(String exch) {
        this.exch = exch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }
}
