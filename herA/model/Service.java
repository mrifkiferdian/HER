/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herA.model;

/**
 *
 * @author mhdri
 */
public class Service {
    private String kode_trans;
    private String tgl_trans;
    private String pelanggan;
    private String jns_service;
    private String biaya;
    private int disc;
    private int total;
    
   public Service(){
        
    }
   Service(String kode_trans, String tgl_trans, String pelanggan, String jns_service, String biaya, int disc, int total) {
        this.kode_trans = kode_trans;
        this.tgl_trans = tgl_trans;
        this.pelanggan = pelanggan;
        this.jns_service = jns_service;
        this.biaya = biaya;
        this.disc = disc;
        this.total = total;
    }
   
    public void setkode_trans(String kode_trans){
        this.kode_trans=kode_trans;
    }
    
    public void settgl_trans(String tgl_trans){
        this.tgl_trans=tgl_trans;
    }
    
    public void setpelanggan(String pelanggan){
        this.pelanggan=pelanggan;
    }
    
    public void setjns_service(String jns_service){
        this.jns_service=jns_service;
    }
    
    public void setbiaya(String biaya){
        this.biaya=biaya;
    }
    
    public void setdisc(int disc){
        this.disc=disc;
    }
    
    public void settotal(int total){
        this.total=total;
    }
    
    public String getkode_trans(){
        return kode_trans;
    }
    
    public String gettgl_trans(){
        return tgl_trans;
    }
    
    public String getpelanggan(){
        return pelanggan;
    }
    
    public String getjns_service(){
        return jns_service;
    }
    
    public String getbiaya(){
        return biaya;
    }
    
    public int getDisc() {
        int jns_service1 = Integer.parseInt(jns_service);
        if(jns_service1 == 1){
            disc = (int) (0.02 * 50000);
        }
        else if(jns_service1 == 2){
            disc = (int) (0.03 * 60000);
        }
        return disc;
    }

    public int getTotal() {
        total = Integer.parseInt(biaya) - disc;
        return total;
    }
    
    
    
    
    
}