package ru.gruzdov.mvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CITY")
    private Integer id;

    @Column(name = "CITY_NAME")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Department> departments;
}
