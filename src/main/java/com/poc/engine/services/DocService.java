package com.poc.engine.services;

import com.poc.engine.models.Doc;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

@Service
public class DocService {
    private final Map<String, Doc> cache = new HashMap<>();
    //private final Path docPath = Paths.get("src/main/resources/data/docs/");
    private final Path docPath = Paths.get("src/main/resources/data/docs/");

    public void refreshCache() {
        cache.clear();
        try (Stream<Path> stream = Files.list(docPath)) {
            stream.filter(p -> p.toString().endsWith(".xml"))
                  .forEach(this::loadXml);
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadXml(Path path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Doc.class);
            Unmarshaller un = context.createUnmarshaller();
            Doc d = (Doc) un.unmarshal(path.toFile());
            if (d != null && d.getId() != null) cache.put(d.getId(), d);
        } catch (Exception e) { System.err.println("Failed: " + path); }
    }

    public Collection<Doc> getAll() { 
        if(cache.isEmpty()) refreshCache();
        return cache.values(); 
    }
    
    public Doc getById(String id) { return cache.get(id); }
}
