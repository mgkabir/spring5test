package io.kabir.spring5test.controller;

import io.kabir.spring5test.model.Widget;
import io.kabir.spring5test.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetRestController {

    @Autowired
    WidgetService service;

    @GetMapping("/rest/widgets/{id}")
    public ResponseEntity<?> getWidget(@PathVariable Long id) {

        return service
                .findById(id)
                .map(widget -> ResponseEntity.ok().body(widget))
                .orElse(ResponseEntity.notFound().build());
    }
}
