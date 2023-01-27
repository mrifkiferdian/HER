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
public class PengembalianDaoImpl implements PengembalianDao{
    List<Pengembalian> data= new ArrayList<>();
    
    public PengembalianDaoImpl(){
        data.add(new Pengembalian("2101092046","B1234","17-06-2022","18-06-2022",3000));
    }
    
    public Pengembalian save(Pengembalian pengembalian){
        data.add(pengembalian);
        return pengembalian;
    }
    public Pengembalian denda(Pengembalian pengembalian){
        data.add(pengembalian);
        return pengembalian;
    }
    public Pengembalian update(int index,Pengembalian pengembalian){
        data.set(index,pengembalian);
        return pengembalian;
    }
    public Pengembalian delete(int index){
        return data.remove(index);
    }
    public Pengembalian getPengembalian(int index){
        return data.get(index);
    }
    public List<Pengembalian> getAllPengembalian(){
        return data;
    }
}
