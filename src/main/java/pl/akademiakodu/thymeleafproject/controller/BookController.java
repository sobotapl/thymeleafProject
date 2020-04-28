package pl.akademiakodu.thymeleafproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.thymeleafproject.model.Book;
import pl.akademiakodu.thymeleafproject.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    //class mapping + method mapping "/book/showall"
    @GetMapping("/showall")
    public String showAllBooks(ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.findAll());
        return "book/showall";
    }

    @GetMapping("/show/{id}")
    public String showAllBooks(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("book", bookService.fineOne(id));
        return "book/showall";
    }

    @GetMapping("/add")
    public String addBook(ModelMap modelMap) {
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("books", bookService.findAll());
        return "book/add";
    }

    @PostMapping("/add")
    public String createBook(@ModelAttribute Book book) {
        log.info("I'm creating book={}", book);
        try {
            bookService.save(book);
        } catch (IllegalAccessException e) {
            log.error("Saving book operation failed", e);
        }

        return "redirect:/book/add";
    }


    //POST
    //GET
    //PUT
    //DELETE
}
