package am.hitech.connectTo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> states;

}
