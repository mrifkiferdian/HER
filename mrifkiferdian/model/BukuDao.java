/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrifkiferdian.model;
import mrifkiferdian.model.Buku;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface BukuDao {
    void save(Buku buku);
    void update(int index, Buku buku);
    void delete (int index);
    Buku getBuku(int index);
    List<Buku> getAll();
}
