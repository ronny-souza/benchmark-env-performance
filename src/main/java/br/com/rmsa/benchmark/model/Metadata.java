package br.com.rmsa.benchmark.model;

import jakarta.persistence.*;

@Entity
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "JSON")
    private String data;

    public Metadata() {

    }

    public Metadata(String data) {
        this.data = data;
    }
}
