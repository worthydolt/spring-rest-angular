package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A DTO to represent the data about the establishment. We only actually care about the rating at the moment but
 * could easily add other properties to unmarshal into
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
