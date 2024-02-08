package am.hitech.connectTo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inet_info")
public class InetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JsonIgnore
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "speed")
    private String speed;

}
