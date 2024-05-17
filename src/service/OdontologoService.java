package service;

import dao.OdontologoDAOArrayList;
import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDaoH2;
    private iDao<Odontologo> odontologoiDaoArray;

    public OdontologoService() {
        odontologoiDaoH2 = new OdontologoDAOH2();
        odontologoiDaoArray = new OdontologoDAOArrayList();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDaoH2.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologo(){
        return odontologoiDaoH2.buscarTodos();
    }

    public Odontologo guardarOdontologoEnArray(Odontologo odontologo){
        return odontologoiDaoArray.guardar(odontologo);
    }
    public List<Odontologo> listarOdontologosEnArray(){
        return odontologoiDaoArray.buscarTodos();
    }
}
