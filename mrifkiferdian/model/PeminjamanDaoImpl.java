/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class PeminjamanDaoImpl implements PeminjamanDao{
    List<Peminjaman> data= new ArrayList<>();
    
    public PeminjamanDaoImpl(){
        data.add(new Peminjaman("0053","B001","17-05-2022","17-06-2022"));
        data.add(new Peminjaman("0056","B002","19-06-2022","19-07-2022"));
        data.add(new Peminjaman("0059","B003","12-02-2022","12-03-2022"));
    }
    
    
    public Peminjaman save(Peminjaman peminjaman){
        data.add(peminjaman);
        return peminjaman;
    }
    
    public Peminjaman update(int index,Peminjaman peminjaman){
        data.set(index,peminjaman);
        return peminjaman;
    }
    
    public Peminjaman delete(int index){
        return data.remove(index);
    }
    
    public Peminjaman  getPeminjaman(int index){
        return data.get(index);
    }
    
    public List<Peminjaman> getAllPeminjaman(){
        return data;
    }
}
