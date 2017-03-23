package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by neil on 21/03/17.
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
