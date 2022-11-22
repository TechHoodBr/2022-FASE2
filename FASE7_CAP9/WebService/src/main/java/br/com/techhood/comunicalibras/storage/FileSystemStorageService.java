package br.com.techhood.comunicalibras.storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileSystemStorageService {

    private final Path rootLocation;

    public FileSystemStorageService(StorageProperties properties, String pastaUpload) {
        this.rootLocation = Paths.get(properties.getLocation().concat(pastaUpload));
    }

    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Falha ao armazenar arquivo vazio " + file.getOriginalFilename());
            }
            init();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("Falha ao armazenar o arquivo " + file.getOriginalFilename(), e);
        }
    }

    public Stream<Path> loadAll() {
        try {
            init();
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Falha ao ler os arquivos armazenados", e);
        }

    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Não foi possível ler o arquivo: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Não foi possível ler o arquivo: " + filename, e);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (FileAlreadyExistsException e) {
            /* Nothing */
        } catch (IOException e) {
            throw new StorageException("Não foi possível inicializar o armazenamento", e);
        }
    }
}
