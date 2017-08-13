package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * * DTO into which to unmarshal the {@link Establishment} array we get back from the API service
 */
public class Establishments {
    @JsonProperty("establishments")
    private List<Establishment> establishments;

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }
}
