package io.kabir.spring5test.controller;

import io.kabir.spring5test.model.Widget;
import io.kabir.spring5test.service.WidgetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class WidgetRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WidgetService service;

    @Test
    @DisplayName("GET /rest/widgets/1")
    void testGETWIdget() throws Exception{

        Widget aWidget = new Widget(1L,"Widget1","Widget One",0);
        doReturn(Optional.of(aWidget)).when(service).findById(1L);

        mockMvc
                .perform(get("/rest/widgets/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("Widget1")));

        verify(service, times(1)).findById(1L);
    }
}