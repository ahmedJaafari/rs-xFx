package rs.xfx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
  private String sharedFolderPath =
    "/Users/ahmedjaafari/rs-xFx/app/SharedFolder/";

  @GetMapping("")
  public List<String> getFiles() {
    File sharedFolder = new File(sharedFolderPath);
    File[] files = sharedFolder.listFiles();
    List<String> filenames = new ArrayList<>();
    for (File file : files) {
      if (file.isFile()) {
        filenames.add(file.getName());
      } else if (file.isDirectory()) {
        filenames.add(file.getName() + "/");
      }
    }
    return filenames;
  }

  @GetMapping("/{filename}")
  public ResponseEntity<Resource> getFile(@PathVariable String filename)
    throws IOException {
    File file = new File(sharedFolderPath + filename);
    HttpHeaders headers = new HttpHeaders();
    headers.add(
      HttpHeaders.CONTENT_DISPOSITION,
      "attachment; filename=" + filename
    );
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");
    Path path = Paths.get(sharedFolderPath + filename);
    ByteArrayResource resource = new ByteArrayResource(
      Files.readAllBytes(path)
    );
    return ResponseEntity
      .ok()
      .headers(headers)
      .contentLength(file.length())
      .contentType(MediaType.APPLICATION_OCTET_STREAM)
      .body(resource);
  }

  @PostMapping(value = "", consumes = { "multipart/form-data" })
  public ResponseEntity<?> uploadFile(
    @RequestParam(required = false) String filename,
    @RequestParam("file") MultipartFile uploadfile
  ) {
    String fname = filename;
    if (filename==null) fname = uploadfile.getOriginalFilename();
    if (uploadfile.isEmpty()) {
      return new ResponseEntity("You must select a file!", HttpStatus.OK);
    }
    try {
      saveUploadedFiles(Arrays.asList(uploadfile), fname);
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(
      "Successfully uploaded - " + fname,
      new HttpHeaders(),
      HttpStatus.OK
    );
  }

  @PutMapping("/{filename}")
  public ResponseEntity<Void> renameFile(
    @PathVariable String filename,
    @RequestParam String newFilename
  )
    throws IOException {
    File file = new File(sharedFolderPath + filename);
    if (!file.exists()) {
      return ResponseEntity.notFound().build();
    }
    File newFile = new File(sharedFolderPath + newFilename);
    if (newFile.exists()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    boolean success = file.renameTo(newFile);
    if (!success) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{filename}")
  public ResponseEntity<Void> deleteFile(@PathVariable String filename) {
    File file = new File(sharedFolderPath + filename);
    if (!file.exists()) {
      return ResponseEntity.notFound().build();
    }
    boolean success = file.delete();
    if (!success) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.ok().build();
  }

  private void saveUploadedFiles(List<MultipartFile> files, String filename) throws IOException {
    File folder = new File(sharedFolderPath);
    if (!folder.exists()) {
      folder.mkdir();
    }
    for (MultipartFile file : files) {
      if (file.isEmpty()) {
        continue;
      }
      byte[] bytes = file.getBytes();
      Path path = Paths.get(sharedFolderPath + filename);
      Files.write(path, bytes);
    }
  }
}
