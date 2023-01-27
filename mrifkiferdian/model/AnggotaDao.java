/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import mrifkiferdian.model.Anggota;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface AnggotaDao {
    void save(Anggota anggota);
    void update(int index, Anggota anggota);
    void delete (int index);
    Anggota getAnggota(int index);
    List<Anggota> getAll();
}
