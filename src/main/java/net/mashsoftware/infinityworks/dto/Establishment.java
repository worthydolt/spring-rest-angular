package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by neil on 26/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Establishment {

    public Establishment() {
    }

    @JsonProperty("RatingValue") private String ratingValue;

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }
}
