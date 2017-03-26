package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by neil on 26/03/17.
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
