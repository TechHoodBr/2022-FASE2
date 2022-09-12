package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.service.UsuarioService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null || Strings.isBlank(usuarioDTO.getLogin()) || Strings.isBlank(usuarioDTO.getSenha())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<UsuarioDTO> usuarios = usuarioService.buscar(usuarioDTO);
        if (usuarios == null || usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(usuarios.get(0), HttpStatus.OK);
    }
}
