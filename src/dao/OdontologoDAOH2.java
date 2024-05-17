package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT_ODO = "INSERT INTO ODONTOLOGO VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement insertOdontologo = connection.prepareStatement(SQL_INSERT_ODO);
            insertOdontologo.setInt(1,odontologo.getNumeroMatricula());
            insertOdontologo.setString(2, odontologo.getNombre());
            insertOdontologo.setString(3, odontologo.getApellido());
            insertOdontologo.execute();
            LOGGER.info("Odontologo guardado en la base de datos");

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        ResultSet rs = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        try{
            connection = BD.getConnection();
            PreparedStatement selectAll = connection.prepareStatement(SQL_SELECT_ALL);
            rs = selectAll.executeQuery();
            while(rs.next()){
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                odontologoList.add(odontologo);
            }
            LOGGER.info("Listado de odontologos completo");
        }catch(Exception e){
            LOGGER.warn(e.getMessage());
        }
        return odontologoList;
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
