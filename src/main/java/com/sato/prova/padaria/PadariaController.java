package com.sato.prova.padaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/breadstore")
public class PadariaController {

    @Autowired
    private PadariaService padariaService;

    @GetMapping
    public ResponseEntity<List<PadariaModel>> findAll(){

        List<PadariaModel> response = padariaService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PadariaModel> criarPadaria(@RequestBody PadariaModel padariaModel){
        PadariaModel response = padariaService.criarPadaria(padariaModel);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarId( @PathVariable Long id){
        padariaService.deletarPadaria(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PadariaModel> atualizarPadaria(@PathVariable Long id, @RequestBody PadariaModel padariaModel) {
        PadariaModel response = padariaService.atualizarPadaria(id, padariaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PadariaModel> buscarId( @PathVariable Long id){
        PadariaModel response = padariaService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<PadariaModel> buscarPorNome( @PathVariable String nome){
        PadariaModel response = padariaService.findByNome(nome);
        return ResponseEntity.ok().body(response);
    }



}
