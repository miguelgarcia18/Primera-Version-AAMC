
package Controller;

import Biblioteca.Libro;
import Config.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author AAMC♡
 */
@Controller
public class Controlador {
    //Instancia de la clase conexion
    Conexion con = new Conexion(); 
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql = "select * from libro";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("index");
        return mav;    
    }  
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
    mav.addObject(new Libro());
        mav.setViewName("agregar");
        return mav;   
    }  
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Libro l){
        String sql = "insert into libro(NombreDelLibro, Autor, FechaPublicacion)values(?,?,?)";
        this.jdbcTemplate.update(sql,l.getNombreLibro(),l.getAutor(),l.getPublicacion());
        return new ModelAndView("redirect:/index.htm");   
    }
    @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql ="select * from libro where Id_libro="+id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("editar");
        return mav;
    }
    @RequestMapping(value = "editar.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Libro l){
        String sql = "update libro set NombreDelLibro=?, Autor=?,FechaPublicacion=? where Id_libro=?";
        this.jdbcTemplate.update(sql,l.getNombreLibro(),l.getAutor(),l.getPublicacion(),id);
        return new ModelAndView("redirect:/index.htm");             
    }
     @RequestMapping("eliminar.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from libro where Id_libro="+id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/index.htm");
    }
}