/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import mrifkiferdian.model.Anggota;
import mrifkiferdian.model.AnggotaDao;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class AnggotaDaoImpl implements AnggotaDao{
    List<Anggota> data = new ArrayList<>();
    
    public AnggotaDaoImpl(){
        data.add(new Anggota("2101092046","Susanna","Lubasa"));
        data.add(new Anggota("2101099292","Nayana","Pagamba"));
        data.add(new Anggota("2101099120","Amaika","Lubaya"));
    }
    
    public void save(Anggota anggota){
        data.add(anggota);
    }
    public void update(int index, Anggota anggota){
        data.set(index, anggota);
    }
    public void delete (int index){
        data.remove(index);
    }
    public Anggota getAnggota(int index){
        return data.get(index);
    }
    public List<Anggota> getAll(){
        return data;
    }
}
