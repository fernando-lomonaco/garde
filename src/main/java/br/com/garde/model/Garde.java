package br.com.garde.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Garde implements Serializable {

    public static final String CACHE_NAME = "Garde";
    
    @Id
    private String identifier;
    private String value;
    private String description;
}
