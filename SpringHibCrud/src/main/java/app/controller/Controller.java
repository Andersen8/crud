package app.controller;
import app.dao.BookFac;
import app.dao.entity.Books;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Андрей on 03.02.2018.
 */
@org.springframework.stereotype.Controller
@ComponentScan(basePackages = "app.controller")
@RequestMapping("/")
public class Controller {
    BookFac bf = BookFac.getInstance();

    public Controller() throws SQLException, ClassNotFoundException {

    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView showAllBooks(HttpServletRequest rq) throws SQLException {
        Integer integer1 = 0;
        Integer integer2 = 10;
        rq.getSession().setAttribute("firstrow", integer1);
        rq.getSession().setAttribute("rowcount", integer2);
        return new ModelAndView("list", "list", bf.pagination(integer2, integer1));
    }
    @RequestMapping(value = "/paginationP", method = RequestMethod.POST)
    public ModelAndView paginationP(HttpServletRequest rq) throws SQLException {
        Integer integer2 = (Integer) rq.getSession().getAttribute("rowcount");
        Integer integer1 = (Integer) rq.getSession().getAttribute("firstrow");
        integer1+=integer2;
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }
    @RequestMapping(value = "/paginationM", method = RequestMethod.POST)
    public ModelAndView paginationM(HttpServletRequest rq) throws SQLException {
        Integer integer2 = (Integer) rq.getSession().getAttribute("rowcount");
        Integer integer1 = (Integer) rq.getSession().getAttribute("firstrow");
        integer1-=integer2;
        if (integer1<0){
            integer1=0;
        }
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBook(@RequestParam String title, @RequestParam String description,
                                @RequestParam String author, @RequestParam String isbn,
                                @RequestParam String printYear, @RequestParam String readAlready,
                                HttpServletRequest rq) throws SQLException {
        Byte b;
        Integer integer1 = 0;
        Integer integer2 = 10;
        rq.getSession().setAttribute("firstrow", integer1);
        rq.getSession().setAttribute("rowcount", integer2);
        if(readAlready.equals("true")){
            b = 1;
        }else{b = 0;}
        bf.addNewBook(title, description, author, isbn, Integer.parseInt(printYear), b);
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView toAddBook() throws SQLException {
        return new ModelAndView("add", "list", bf.getAllBooks());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteBook(@RequestParam String id, HttpServletRequest rq) throws SQLException {
        bf.deleteBook(Integer.parseInt(id));
        Integer integer2 = (Integer) rq.getSession().getAttribute("rowcount");
        Integer integer1 = (Integer) rq.getSession().getAttribute("firstrow");
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }

    @RequestMapping(value = "/updateread", method = RequestMethod.POST)
    public ModelAndView updateByRead(@RequestParam String id, HttpServletRequest rq) throws SQLException {
        bf.updateBook(Integer.parseInt(id));
        Integer integer2 = (Integer) rq.getSession().getAttribute("rowcount");
        Integer integer1 = (Integer) rq.getSession().getAttribute("firstrow");
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }

    @RequestMapping(value = "/updatetdip", method = RequestMethod.GET)
    public ModelAndView updateChange(@RequestParam int id, HttpServletRequest hsr) throws SQLException {
        Integer integ = new Integer(id);
        hsr.getSession().setAttribute("id", integ);
       return new ModelAndView("edit", "list", bf.getAllBooks());
    }

    @RequestMapping(value = "/change")
    public ModelAndView exceptChanges(HttpServletRequest rq,
                                      @RequestParam String title,
                                      @RequestParam String description,
                                      @RequestParam String isbn,
                                      @RequestParam String printYear) throws SQLException {
        Integer integ = (Integer) rq.getSession().getAttribute("id");
        bf.changeBook(integ,title,description,isbn,Integer.parseInt(printYear));
        Integer integer2 = (Integer) rq.getSession().getAttribute("rowcount");
        Integer integer1 = (Integer) rq.getSession().getAttribute("firstrow");
        return new ModelAndView("list", "list", bf.pagination(integer2,integer1));
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView findByTitle(@RequestParam String find)throws SQLException{
        List<Books> ls = bf.findByTitle(find);
        return new ModelAndView("list", "list", ls);
    }

}
