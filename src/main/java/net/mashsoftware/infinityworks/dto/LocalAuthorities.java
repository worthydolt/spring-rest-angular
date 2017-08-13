package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO into which to unmarshal the {@link LocalAuthority} array we get back from the API service
 */
public class LocalAuthorities {
    @JsonProperty("authorities")
    private List<LocalAuthority> localAuthorities;

    public LocalAuthorities() {

    }

    public List<LocalAuthority> getLocalAuthorities() {
        return localAuthorities;
    }

    public void setLocalAuthorities(List<LocalAuthority> localAuthorities) {
        this.localAuthorities = localAuthorities;
    }
}
