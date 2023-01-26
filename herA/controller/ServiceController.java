/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herA.controller;

/**
 *
 * @author mhdri
 */
import herA.model.*;
import herA.view.FormService;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ServiceController {
    private FormService formservice;
    private ServiceDao serviceDao;
    private Service service;
    
    public ServiceController (FormService formservice){
        this.formservice = formservice;
        serviceDao = new ServiceDaoImpl();
    }
    
    public void bersihForm(){
        formservice.getTxtkode().setText("");
        formservice.getTxttgl().setText("");
        formservice.getTxtpelanggan().setText("");
        formservice.getTxtjenis().setText("");
        formservice.getTxtbiaya().setText("");
    }
    
    public void save(){
        service = new Service();
        service.setkode_trans(formservice.getTxtkode().getText());
        service.settgl_trans(formservice.getTxttgl().getText());
        service.setpelanggan(formservice.getTxtpelanggan().getText());
        service.setjns_service(formservice.getTxtjenis().getText());
        service.setbiaya(formservice.getTxtbiaya().getText());
        serviceDao.save(service);
        javax.swing.JOptionPane.showMessageDialog(formservice, "Entri Ok");
    }
    
    public void getService(){
        int index = formservice.getTblservice().getSelectedRow();
        service = serviceDao.getService(index);
        if(service != null){
            formservice.getTxtkode().setText(service.getkode_trans());
            formservice.getTxttgl().setText(service.gettgl_trans());
            formservice.getTxtpelanggan().setText(service.getpelanggan());
            formservice.getTxtjenis().setText(service.getjns_service());
            formservice.getTxtbiaya().setText(service.getbiaya());
        }
    }
    
    public void update(){
        int index = formservice.getTblservice().getSelectedRow();
        service.setkode_trans(formservice.getTxtkode().getText());
        service.settgl_trans(formservice.getTxttgl().getText());
        service.setpelanggan(formservice.getTxtpelanggan().getText());
        service.setjns_service(formservice.getTxtjenis().getText());
        service.setbiaya(formservice.getTxtbiaya().getText());
        serviceDao.update(index, service);
        javax.swing.JOptionPane.showMessageDialog(formservice, "Entri Ok");
    }
    
    public void delete(){
        int index = formservice.getTblservice().getSelectedRow();
        serviceDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formservice, "Delete Ok");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
                (DefaultTableModel) formservice.getTblservice().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Service> list = serviceDao.getAll();
        for(Service service : list){
            Object[] data = {
                service.getkode_trans(),
                service.gettgl_trans(),
                service.getpelanggan(),
                service.getjns_service(),
                service.getbiaya(),
                service.getDisc(),
                service.getTotal(),
            };
            tabelModel.addRow(data);
        }
    }
    
}
