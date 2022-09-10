package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.service.UsuarioService;
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
    public ResponseEntity<HttpStatus> login(@RequestBody UsuarioDTO usuarioDTO) {

        List<UsuarioDTO> usuarios = usuarioService.buscar(usuarioDTO);
        if (usuarios == null || usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
