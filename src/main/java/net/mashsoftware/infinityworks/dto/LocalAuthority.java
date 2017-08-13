package net.mashsoftware.infinityworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

/**
 * DTO to represent each of the authorities returned from the REST call to get the list of available authorities.
 * Unfortunately we need a load of @JsonProperty boiler-plate to enable Jackson to find the appropriate variable name
 * due to the casing of variable names in the REST service not matching the convention used for JavaBeans
 */
public class LocalAuthority {

    @JsonProperty("LocalAuthorityId") private int localAuthorityId;
    @JsonProperty("LocalAuthorityIdCode") private String localAuthorityIdCode;
    @JsonProperty("Name") private String name;
    @JsonProperty("FriendlyName") private String friendlyName;
    @JsonProperty("Url") private String url;
    @JsonProperty("SchemeUrl") private String schemeUrl;
    @JsonProperty("Email") private String email;
    @JsonProperty("RegionName") private String regionName;
    @JsonProperty("FileName") private String fileName;
    @JsonProperty("FileNameWelsh") private String fileNameWelsh;
    @JsonProperty("EstablishmentCount") private int establishmentCount;
    @JsonProperty("CreationDate") private String creationDate;
    @JsonProperty("LastPublishedDate") private String lastPublishedDate;
    @JsonProperty("SchemeType") private int schemeType;
    @JsonProperty("links") private List<Map<String, String>> links;

    public LocalAuthority(){

    }

    public String getLocalAuthorityIdCode() {
        return localAuthorityIdCode;
    }

    public void setLocalAuthorityIdCode(String localAuthorityIdCode) {
        this.localAuthorityIdCode = localAuthorityIdCode;
    }

    public int getLocalAuthorityId() {
        return localAuthorityId;
    }

    public void setLocalAuthorityId(int localAuthorityId) {
        this.localAuthorityId = localAuthorityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSchemeUrl() {
        return schemeUrl;
    }

    public void setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameWelsh() {
        return fileNameWelsh;
    }

    public void setFileNameWelsh(String fileNameWelsh) {
        this.fileNameWelsh = fileNameWelsh;
    }

    public int getEstablishmentCount() {
        return establishmentCount;
    }

    public void setEstablishmentCount(int establishmentCount) {
        this.establishmentCount = establishmentCount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastPublishedDate() {
        return lastPublishedDate;
    }

    public void setLastPublishedDate(String lastPublishedDate) {
        this.lastPublishedDate = lastPublishedDate;
    }

    public int getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(int schemeType) {
        this.schemeType = schemeType;
    }

    public List<Map<String, String>> getLinks() {
        return links;
    }

    public void setLinks(List<Map<String, String>> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
