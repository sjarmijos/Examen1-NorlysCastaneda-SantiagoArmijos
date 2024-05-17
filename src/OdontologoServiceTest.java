import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoServiceTest {

    @Test
    public void listarOdontologosH2(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(new Odontologo(1,"Juan","Perez"));
        odontologoService.guardarOdontologo(new Odontologo(2,"Maria","Gomez"));
        odontologoService.guardarOdontologo(new Odontologo(3,"Norlys","Castañeda"));

        System.out.println("**************Resultados en H2******************");
        List<Odontologo> odontologoList = odontologoService.listarOdontologo();
        System.out.println(odontologoList);
        Assertions.assertTrue(odontologoList != null);
        Assertions.assertEquals(3,odontologoList.size());
        System.out.println("*****************************************************************************************");
    }

    @Test
    public void listarOdontologoArrayList(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologoEnArray(new Odontologo(1,"Hermione","Grenger"));
        odontologoService.guardarOdontologoEnArray(new Odontologo(2,"Ron","Weasly"));
        odontologoService.guardarOdontologoEnArray(new Odontologo(3,"Harry","Potter"));
        odontologoService.guardarOdontologoEnArray(new Odontologo(4,"JK","Rowling"));

        System.out.println("**************Resultados en Array List******************");
        List<Odontologo> odontologoArrayList = odontologoService.listarOdontologosEnArray();
        System.out.println(odontologoArrayList);
        Assertions.assertTrue(odontologoArrayList!=null);
        Assertions.assertEquals(4,odontologoArrayList.size());
        System.out.println("***************************************************************************");
    }
}
