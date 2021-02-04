package com.rogers.demo.controller;

import com.google.gson.Gson;
import com.rogers.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentControllerTest {

  @Autowired
  private MockMvc mvc;

  Gson gson;

  @Test
  public void getStudentList() throws Exception{
   RequestBuilder requestBuilder= MockMvcRequestBuilders
           .get("/students/list");
      mvc.perform(requestBuilder).andDo(print())
           .andExpect(status().isOk());
  }

  @Test
  public void insertStudent() throws Exception{
      Student student=new Student();
      gson=new Gson();
      student.setAddress("22 homewood Avenue,north york,on,m2m1j9");
      student.setName("matt");
      student.setCity("Toronto");
      student.setPhone("6478545559");

      RequestBuilder requestBuilder=MockMvcRequestBuilders
              .post("/student/add")
              .contentType("application/json")
              .content(gson.toJson(student));
      mvc.perform(requestBuilder).andDo(print())
              .andExpect(status().isOk());
  }
    @Test
    public void insertStudentCheckName() throws Exception{
        Student student=new Student();
        gson=new Gson();
        student.setAddress("22 homewood Avenue,north york,on,m2m1j9");
        student.setCity("Toronto");
        student.setPhone("6478545559");

        RequestBuilder requestBuilder=MockMvcRequestBuilders
                .post("/student/add")
                .contentType("application/json")
                .content(gson.toJson(student));
        mvc.perform(requestBuilder).andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test
    public void deleteStudent() throws Exception{
      RequestBuilder requestBuilder= MockMvcRequestBuilders
              .delete("/student/remove/3");
      mvc.perform(requestBuilder).andDo(print())
              .andExpect(status().isOk());

    }
    @Test
    public void deleteStudentWithOutId() throws Exception{
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .delete("/student/remove");
        mvc.perform(requestBuilder).andDo(print())
                .andExpect(status().isNotFound());

    }


}
