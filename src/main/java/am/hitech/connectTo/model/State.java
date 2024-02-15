package am.hitech.connectTo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "state")
@Entity
public class State {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "state")
    private String state;

    @Column(name = "country_id")
    private int countryId;

    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;*/

    /*@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    List<ZipCode> zipCodes;*/
}
