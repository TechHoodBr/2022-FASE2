package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.AulaDTO;
import br.com.techhood.comunicalibras.service.AulaService;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aula")
public class AulaController extends RestCrudController<AulaDTO> {

    private final String pastaUpload = "/aula/";
    private final StorageProperties properties;

    @Autowired
    public AulaController(AulaService aulaService, StorageProperties properties) {
        super.crudService = aulaService;
        this.properties = properties;
    }

    @GetMapping("/{id}/arquivos")
    public List arquivosUploaded(@PathVariable("id") Long id) {

        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload + id);

        List arquivos = fileSystemStorageService.loadAll().map(
                path -> getServidorArquivo(id, path.getFileName().toString()))
                .collect(Collectors.toList());

        return arquivos;
    }

    @GetMapping("/{id}/arquivo/{arquivo:.+}")
    @ResponseBody
    public ResponseEntity<Resource> servidorArquivo(@PathVariable("id") Long id, @PathVariable("arquivo") String arquivo) {
        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload + id);
        Resource file = fileSystemStorageService.loadAsResource(arquivo);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/{id}/arquivo")
    public void arquivoUpload(@PathVariable("id") Long id, @RequestParam("arquivo") MultipartFile arquivo) {
        FileSystemStorageService fileSystemStorageService = new FileSystemStorageService(properties, pastaUpload + id);
        AulaDTO aulaDTO = super.crudService.buscarPorId(id);
        aulaDTO.setVideo(getServidorArquivo(id, arquivo.getOriginalFilename()));
        super.crudService.atualizarPorId(id, aulaDTO);
        fileSystemStorageService.store(arquivo);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> arquivoNaoLocalizado(StorageFileNotFoundException storageFileNotFoundException) {
        return ResponseEntity.notFound().build();
    }

    private String getServidorArquivo(Long id, String nomeArquivo) {
        return MvcUriComponentsBuilder.fromMethodName(
                AulaController.class, "servidorArquivo",
                id,
                nomeArquivo
        ).build().toUri().toString();
    }
}
