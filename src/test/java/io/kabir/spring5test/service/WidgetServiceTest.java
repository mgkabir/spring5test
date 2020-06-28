package io.kabir.spring5test.service;

import io.kabir.spring5test.model.Widget;
import io.kabir.spring5test.repository.WidgetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WidgetServiceTest {
    @Autowired
    WidgetService service;

    @MockBean
    WidgetRepository repository;

    @Test
    void testFindById() {

        Widget aWidget = new Widget(22L, "Widget 22", "Widget Twenty Two", 0);
        Mockito.doReturn(Optional.of(aWidget)).when(repository).findById(22L);

        Optional<Widget> retrievedWidget = service.findById(22L);

        assertTrue(retrievedWidget.isPresent());
        assertEquals(22, retrievedWidget.get().getId());
    }
}