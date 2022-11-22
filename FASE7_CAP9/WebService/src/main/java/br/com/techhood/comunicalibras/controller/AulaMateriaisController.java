package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.AulaMateriaisDTO;
import br.com.techhood.comunicalibras.service.AulaMateriaisService;
import br.com.techhood.comunicalibras.storage.FileSystemStorageService;
import br.com.techhood.comunicalibras.storage.StorageFileNotFoundException;
import br.com.techhood.comunicalibras.storage.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/aulaMateriais")
public class AulaMateriaisController extends RestCrudController<AulaMateriaisDTO> {

    private final String pastaUpload = "/aula/{id}/materiais/";
    private final StorageProperties properties;

    @Autowired
    public AulaMateriaisController(AulaMateriaisService aulaMateriaisService, StorageProperties properties) {
        super.crudService = aulaMateriaisService;
        this.properties = properties;
    }

    // ID - Chave da Aula
    @GetMapping("/{id}/arquivos")
    public List arquivosUploaded(@PathVariable("id") Long id) {

        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload.replace("{id}", id.toString()));

        List arquivos = fileSystemStorageService.loadAll().map(
                path -> getServidorArquivo(id, path.getFileName().toString()))
                .collect(Collectors.toList());

        return arquivos;
    }

    // ID - Chave da Aula
    @GetMapping("/{id}/arquivo/{arquivo:.+}")
    @ResponseBody
    public ResponseEntity<Resource> servidorArquivo(@PathVariable("id") Long id, @PathVariable("arquivo") String arquivo) {
        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload.replace("{id}", id.toString()));
        AulaMateriaisDTO aulaMateriaisDTO = super.crudService.buscarPorId(id);
        aulaMateriaisDTO.setBaixado(aulaMateriaisDTO.getBaixado()+1);
        super.crudService.atualizarPorId(id, aulaMateriaisDTO);
        Resource file = fileSystemStorageService.loadAsResource(arquivo);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    // ID - Chave da Aula
    @PostMapping("/{id}/arquivo")
    public void arquivoUpload(@PathVariable("id") Long id, @RequestParam("arquivo") MultipartFile arquivo) {
        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload.replace("{id}", id.toString()));
        AulaMateriaisDTO aulaMateriaisDTO = super.crudService.buscarPorId(id);
        aulaMateriaisDTO.setNome_arquivo(arquivo.getOriginalFilename());
        aulaMateriaisDTO.setArquivo(getServidorArquivo(id, arquivo.getOriginalFilename()));
        aulaMateriaisDTO.setUpload(LocalDateTime.now());
        super.crudService.atualizarPorId(id, aulaMateriaisDTO);
        fileSystemStorageService.store(arquivo);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> arquivoNaoLocalizado(StorageFileNotFoundException storageFileNotFoundException) {
        return ResponseEntity.notFound().build();
    }

    private String getServidorArquivo(Long id, String nomeArquivo) {
        return MvcUriComponentsBuilder.fromMethodName(
                AulaMateriaisController.class, "servidorArquivo",
                id,
                nomeArquivo
        ).build().toUri().toString();
    }
}
