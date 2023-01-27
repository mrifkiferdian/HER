/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.controller;
import mrifkiferdian.model.*;
import mrifkiferdian.view.FormPengembalian;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class PengembalianController {
    private FormPengembalian formPengembalian;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private PeminjamanDao peminjamanDao;
    private Pengembalian pengembalian;
    private PengembalianDao pengembalianDao;
    
    public PengembalianController(FormPengembalian formPengembalian){
        this.formPengembalian=formPengembalian;
        anggotaDao= new AnggotaDaoImpl();
        bukuDao= new BukuDaoImpl();
        peminjamanDao=new PeminjamanDaoImpl();
        pengembalianDao=new PengembalianDaoImpl();
    }
    
    public void bersihForm(){
        formPengembalian.getTxttglpengembalian().setText("");
    }
    
    public void setCboNobp(){
        formPengembalian.getCbonobp().removeAllItems();
        List<Anggota> list= anggotaDao.getAll();
        for(Anggota anggota : list){
            formPengembalian.getCbonobp().
                    addItem(anggota.getNobp()+"-"+anggota.getNama());
        } 
    }
    
    public void setCboKodeBuku(){
        formPengembalian.getCbokode().removeAllItems();
        List<Buku> list= bukuDao.getAll();
        for(Buku buku : list){
            formPengembalian.getCbokode().
                    addItem(buku.getKodebuku());
        } 
    }
    
    public void setCboKembali(){
        formPengembalian.getCbokembali().removeAllItems();
        List<Peminjaman> list= peminjamanDao.getAllPeminjaman();
        for(Peminjaman peminjaman : list){
            formPengembalian.getCbokembali().
                    addItem(peminjaman.getTglkembali());
        } 
    }
    
    public void save(){
        pengembalian=new Pengembalian();
        pengembalian.setNobp(formPengembalian.getCbonobp()
                .getSelectedItem().toString().split("-")[0]);
        pengembalian.setKode(formPengembalian.getCbokode()
                .getSelectedItem().toString());
        pengembalian.setTglkembali(formPengembalian.getCbokembali()
                .getSelectedItem().toString());
        pengembalian.setTglpengembalian(formPengembalian.getTxttglpengembalian().getText());
        pengembalianDao.save(pengembalian);
        JOptionPane.showMessageDialog(formPengembalian,"Entri Data Ok");
    }
    
    public void getPengembalian(){
        int index=formPengembalian.getTblpengembalian().getSelectedRow();
        pengembalian=pengembalianDao.getPengembalian(index);
        if(pengembalian!=null){
            List<Anggota> listAnggota=anggotaDao.getAll();
            for(Anggota anggota:listAnggota){
                if(pengembalian.getNobp()==anggota.getNobp()){
                    formPengembalian.getCbonobp()
                    .setSelectedItem(anggota.getNobp()+"-"+anggota.getNama());
                    break;
                }
            }
            formPengembalian.getCbokode().setSelectedItem(pengembalian.getKode());
            formPengembalian.getCbokembali().setSelectedItem(pengembalian.getTglkembali());
            formPengembalian.getTxttglpengembalian().setText(pengembalian.getTglpengembalian());
            pengembalian.getDenda();
        }
    }
    
    public void update(){
        int index=formPengembalian.getTblpengembalian().getSelectedRow();
        pengembalian=pengembalianDao.getPengembalian(index);
        pengembalian.setNobp(formPengembalian.getCbonobp()
                .getSelectedItem().toString().split("-")[0]);
        pengembalian.setKode(formPengembalian.getCbokode()
                .getSelectedItem().toString());
        pengembalian.setTglkembali(formPengembalian.getCbokembali()
                .getSelectedItem().toString());
        pengembalian.setTglpengembalian(formPengembalian.getTxttglpengembalian().getText());
        pengembalianDao.update(index,pengembalian);
        JOptionPane.showMessageDialog(formPengembalian,"Update Data Ok");
    }
    
    public void delete(){
        int index=formPengembalian.getTblpengembalian().getSelectedRow();
        pengembalianDao.delete(index);
        JOptionPane.showMessageDialog(formPengembalian,"Delete Data Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel=
                (DefaultTableModel) formPengembalian.getTblpengembalian().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pengembalian>listPengembalian=pengembalianDao.getAllPengembalian();
        for(Pengembalian pengembalian : listPengembalian){
            Object[] data={
                pengembalian.getNobp(),
                pengembalian.getKode(),
                pengembalian.getTglkembali(),
                pengembalian.getTglpengembalian(),
                pengembalian.getDenda()
            };
            tabelModel.addRow(data);
        }
    }
}
