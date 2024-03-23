package br.com.rmsa.benchmark.service;

import br.com.rmsa.benchmark.exception.EmptyFileException;
import br.com.rmsa.benchmark.exception.FileProccessorException;
import br.com.rmsa.benchmark.model.Metadata;
import br.com.rmsa.benchmark.model.parser.CsvToObjectDTO;
import br.com.rmsa.benchmark.repository.MetadataRepository;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProcessFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessFileService.class);

    private final MetadataRepository metadataRepository;

    public ProcessFileService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public Set<CsvToObjectDTO> process(MultipartFile file) throws EmptyFileException, FileProccessorException {
        LOGGER.info("Starting CSV file conversion process...");
        if (file.isEmpty()) {
            throw new EmptyFileException("CSV cannot be parsed because is empty");
        }

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            Set<CsvToObjectDTO> items = this.processFileToObject(reader);

            Gson gson = new Gson();
            List<Metadata> entities = items.stream()
                    .map(gson::toJson)
                    .map(Metadata::new).toList();

            this.metadataRepository.saveAll(entities);
            return items;
        } catch (Exception e) {
            throw new FileProccessorException(e.getMessage(), e);
        }

    }

    private Set<CsvToObjectDTO> processFileToObject(Reader reader) {
        CsvToBean<CsvToObjectDTO> csvToBean = new CsvToBeanBuilder<CsvToObjectDTO>(reader)
                .withType(CsvToObjectDTO.class)
                .withIgnoreEmptyLine(true)
                .withIgnoreLeadingWhiteSpace(true).build();
        return new HashSet<>(csvToBean.parse());
    }
}
