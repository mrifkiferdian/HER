/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;

/**
 *
 * @author Lenovo
 */
public class Pengembalian {
    private String nobp;
    private String kode;
    private String tglkembali;
    private String tglpengembalian;
    private int telat;
    private int denda;
    public int getTglkembali;

    public Pengembalian(){
        
    }

    Pengembalian(String nobp, String kode, String tglkembali, String tglpengembalian, int denda) {
        this.nobp = nobp;
        this.kode = kode;
        this.tglkembali = tglkembali;
        this.tglpengembalian = tglpengembalian;
        this.denda = denda;
    }
    
    public void setNobp(String nobp) {
        this.nobp = nobp;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public void setTglpengembalian(String tglpengembalian) {
        this.tglpengembalian = tglpengembalian;
    }

    public void setDenda(int denda) {
        telat = Integer.parseInt(tglkembali) - Integer.parseInt(tglpengembalian);
        if(telat > 7){
            denda = telat * 3000;
        }else{
            denda = 0;
        }
        this.denda = denda;
    }
    

    public String getNobp() {
        return nobp;
    }

    public String getKode() {
        return kode;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public String getTglpengembalian() {
        return tglpengembalian;
    }

    public int getDenda() {
        return denda;
    }
}
