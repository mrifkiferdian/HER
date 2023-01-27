/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface PengembalianDao {
    Pengembalian save(Pengembalian pengembalian);
    Pengembalian update(int index,Pengembalian pengembalian);
    Pengembalian denda(Pengembalian pengembalian);
    Pengembalian delete(int index);
    Pengembalian getPengembalian(int index);
    List<Pengembalian> getAllPengembalian();
}
