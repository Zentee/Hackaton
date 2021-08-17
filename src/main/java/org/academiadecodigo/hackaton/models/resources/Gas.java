package org.academiadecodigo.hackaton.models.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Gas extends Resource {

    private final String name = "Gas";
    private Integer id;

    public Gas(){
        super.setQuantity(100);
        super.setName(name);
    }

}
