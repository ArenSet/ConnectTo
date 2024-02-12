package am.hitech.connectTo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service_customer")
public class ServiceCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String desc;

    @Column(name = "position")
    private Integer position;

    @Column(name = "icon")
    private String icon;


}
