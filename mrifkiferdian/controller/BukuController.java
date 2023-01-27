/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.controller;
import mrifkiferdian.model.Buku;
import mrifkiferdian.model.BukuDao;
import mrifkiferdian.model.BukuDaoImpl;
import mrifkiferdian.view.FormBuku;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class BukuController {
    private FormBuku formbuku;
    private BukuDao bukuDao;
    private Buku buku;
    
    public BukuController (FormBuku formbuku){
        this.formbuku = formbuku;
        bukuDao = new BukuDaoImpl();
    }
    
    public void bersihForm(){
        formbuku.getTxtKode().setText("");
        formbuku.getTxtJudul().setText("");
        formbuku.getTxtPengarang().setText("");
        formbuku.getTxtPenerbit().setText("");
    }
    
    public void saveBuku(){
        buku = new Buku();
        buku.setKodebuku(formbuku.getTxtKode().getText());
        buku.setJudul(formbuku.getTxtJudul().getText());
        buku.setPengarang(formbuku.getTxtPengarang().getText());
        buku.setPenerbit(formbuku.getTxtPenerbit().getText());
        bukuDao.save(buku);
        javax.swing.JOptionPane.showMessageDialog(formbuku, "Entri Ok");
    }
    
    public void getBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        buku = bukuDao.getBuku(index);
        if(buku != null){
            formbuku.getTxtKode().setText(buku.getKodebuku());
            formbuku.getTxtJudul().setText(buku.getJudul());
            formbuku.getTxtPengarang().setText(buku.getPengarang());
            formbuku.getTxtPenerbit().setText(buku.getPenerbit());
        }
    }
    
    public void updateBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        buku.setKodebuku(formbuku.getTxtKode().getText());
        buku.setJudul(formbuku.getTxtJudul().getText());
        buku.setPengarang(formbuku.getTxtPengarang().getText());
        buku.setPenerbit(formbuku.getTxtPenerbit().getText());
        bukuDao.update(index, buku);
        javax.swing.JOptionPane.showMessageDialog(formbuku, "Entri Ok");
    }
    
    public void deleteBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        bukuDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formbuku, "Delete Ok");
    }
    public void tampilData(){
        DefaultTableModel tabelModel = 
                (DefaultTableModel) formbuku.getTblBuku().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Buku> list = bukuDao.getAll();
        for(Buku buku : list){
            Object[] data = {
                buku.getKodebuku(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
            };
            tabelModel.addRow(data);
        }
    }
}
