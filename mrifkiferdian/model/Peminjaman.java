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
public class Peminjaman {
    private String nobp;
    private String kode;
    private String tglpinjam;
    private String tglkembali;
    
    public Peminjaman(){
        
    }

    Peminjaman(String nobp, String kode, String tglpinjam, String tglkembali) {
        this.nobp = nobp;
        this.kode = kode;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }
    
    
    public void setNobp(String nobp){
        this.nobp=nobp;
    }
    
    public void setKode(String kode){
        this.kode=kode;
    }
    
    public void setTglpinjam(String tglpinjam){
        this.tglpinjam=tglpinjam;
    }
    
    public void setTglkembali(String tglkembali){
        this.tglkembali=tglkembali;
    }
    
    public String getNobp(){
        return nobp;
    }
    
    public String getKode(){
        return kode;
    }
    
    public String getTglpinjam(){
        return tglpinjam;
    }
    
    public String getTglkembali(){
        return tglkembali;
    }
}
