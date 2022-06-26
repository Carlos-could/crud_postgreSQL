package com.carlos.crud.kontrolle;

import com.carlos.crud.model.Schueler;
import com.carlos.crud.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/schueler")
public class SchuelerKontrolle {

    @Autowired
    private SchuelerService schuelerService;

    @PostMapping
    public ResponseEntity<Schueler> speichernSchueler(@RequestBody Schueler schueler){
        return ResponseEntity.status(HttpStatus.CREATED).body(schuelerService.speichernSchueler(schueler));
    }

    @GetMapping
    public ResponseEntity<Page<Schueler>> getAllSchueler(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false,defaultValue = "10") Integer size,
            @RequestParam(required = false,defaultValue = "false") Boolean enablePagination
    ){
        return ResponseEntity.ok(schuelerService.getAllSchueler(page,size,enablePagination));
    }

    @DeleteMapping(value = "/{id}")
    public void loeschenSchueler(@PathVariable("id") Long id){
        schuelerService.loeschenSchueler(id);
        ResponseEntity.ok(!schuelerService.existByid(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Schueler>> findSchuelerById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(schuelerService.findById(id));
    }

//    public Optional<Schueler> findById(Long id){
//        return iSchuelerRepository.findById(id);
//    }

    @PutMapping
    public ResponseEntity <Schueler> editSchueler (@RequestBody Schueler schueler) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schuelerService.editSchueler(schueler));
    }
}
