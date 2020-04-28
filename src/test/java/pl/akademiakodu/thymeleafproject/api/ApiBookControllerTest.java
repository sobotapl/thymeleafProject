package pl.akademiakodu.thymeleafproject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.akademiakodu.thymeleafproject.model.Book;
import pl.akademiakodu.thymeleafproject.service.BookService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiBookController.class)
public class ApiBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

/*
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ApiBookController()).build();
    }
*/


    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        List<Book> books = Arrays.asList(new Book("author", "title", "price"));
        when(bookService.findAll()).thenReturn(books);

        String writeValueAsString = new ObjectMapper().writeValueAsString(books);


        this.mockMvc.perform(
                get("/api/books"))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(writeValueAsString))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].author", is("author")));
    }

    @Test
    public void createBook() throws Exception {
        Book book = new Book("author", "title", "price");

        String jsonString = new ObjectMapper().writeValueAsString(book);

        this.mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isCreated());

        //and
        verify(bookService).save(eq(book));

    }
}