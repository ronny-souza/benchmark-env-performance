package br.com.rmsa.benchmark.model;

import br.com.rmsa.benchmark.model.transport.MetadataDTO;
import jakarta.persistence.*;

@Entity
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String job;

    public Metadata() {
    }

    public Metadata(MetadataDTO metadata) {
        this.firstname = metadata.getFirstname();
        this.lastname = metadata.getLastname();
        this.email = metadata.getEmail();
        this.age = metadata.getAge();
        this.gender = metadata.getGender();
        this.phone = metadata.getPhone();
        this.address = metadata.getAddress();
        this.city = metadata.getCity();
        this.state = metadata.getState();
        this.zipCode = metadata.getZipCode();
        this.country = metadata.getCountry();
        this.job = metadata.getJob();
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getJob() {
        return job;
    }
}
