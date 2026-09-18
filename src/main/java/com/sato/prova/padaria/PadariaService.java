package com.sato.prova.padaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

        @Autowired
        private PadariaRepository padariaRepository;

        public List<PadariaModel> findAll(){
            return padariaRepository.findAll();
        }

        public PadariaModel buscarPorId(Long id){
            return padariaRepository.findById(id).get();
        }

        public PadariaModel criarPadaria(PadariaModel padariaModel){
            return padariaRepository.save(padariaModel);
        }

        public void deletarPadaria(Long id) {
            padariaRepository.deleteById(id);
        }

        public PadariaModel atualizarPadaria(Long id, PadariaModel padariaNew) {
            PadariaModel padariaModel = padariaRepository.findById(id).get();
            padariaModel.setNome(padariaNew.getNome());
            padariaModel.setEndereco(padariaNew.getEndereco());

            return padariaRepository.save(padariaModel);
        }

}
