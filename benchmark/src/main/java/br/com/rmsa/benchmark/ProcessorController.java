package br.com.rmsa.benchmark;

import br.com.rmsa.benchmark.exception.EmptyFileException;
import br.com.rmsa.benchmark.exception.FileProccessorException;
import br.com.rmsa.benchmark.model.StopWatch;
import br.com.rmsa.benchmark.model.parser.CsvToObjectDTO;
import br.com.rmsa.benchmark.service.ProcessFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@RequestMapping("/processor")
public class ProcessorController {
    private final ProcessFileService processFileService;

    public ProcessorController(ProcessFileService processFileService) {
        this.processFileService = processFileService;
    }

    @PostMapping
    public ResponseEntity<Integer> processCsv(@RequestParam("items") MultipartFile issuesCsv) throws EmptyFileException, FileProccessorException {
        StopWatch stopWatch = new StopWatch();
        Set<CsvToObjectDTO> response = this.processFileService.process(issuesCsv);
        stopWatch.getExecutionTime("EXECUTION TIME");
        return ResponseEntity.ok(response.size());
    }
}
