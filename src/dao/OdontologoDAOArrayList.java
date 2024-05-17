package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArrayList implements iDao<Odontologo>{

    private static List<Odontologo> odontologos;
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOArrayList.class);

    public OdontologoDAOArrayList() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        LOGGER.info("Agregando odontologo al ArrayList");
        return odontologo;
    }
    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Listando todos los odontologos del ArrayList");
        return new ArrayList<>(odontologos);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }


}
