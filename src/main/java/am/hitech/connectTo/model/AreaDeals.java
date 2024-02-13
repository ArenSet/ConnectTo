package am.hitech.connectTo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "area_deals")
public class AreaDeals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;

    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    private String service;

    private String email;
}
