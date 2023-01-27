/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import mrifkiferdian.model.Buku;
import mrifkiferdian.model.BukuDao;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class BukuDaoImpl implements BukuDao{
    List<Buku> data = new ArrayList<>();
    
    public BukuDaoImpl(){
        data.add(new Buku("B1234","Sangkuriang","Cahyadi","Sinar Padang"));
        data.add(new Buku("B1254","Danau Toba","Suryono","Gramedia"));
        data.add(new Buku("B1212","Kimia","Dr.Surya","Gramedia"));
    }
    
    public void save(Buku buku){
        data.add(buku);
    }
    public void update(int index, Buku buku){
        data.set(index, buku);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Buku getBuku(int index){
        return data.get(index);
    }
    public List<Buku> getAll(){
        return data;
    }
}
