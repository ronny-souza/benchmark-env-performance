package br.com.rmsa.benchmark.repository;

import br.com.rmsa.benchmark.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
}
