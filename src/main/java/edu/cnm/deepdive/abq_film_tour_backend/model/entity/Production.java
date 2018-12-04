package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties (ignoreUnknown = true)
@Component
@Entity
public class Production {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void initEntityLinks() {
    //Sends a request to the entityLinks to ensure it gets set
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    //Constructs entitylinks after init request is null
    Production.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(generator = "uui2d")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "production_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @Column(unique = true)
  @SerializedName("imdbID")
  //corresponds to i in omdbapi
  private String imdbId;

  @SerializedName("Title")
  //corresponds to t in omdbapi
  private String title;

  @SerializedName("Type")
  //corresponds to type in omdbapi
  //valid options - movie, series, episode
  private String type;

  @SerializedName("Year")
  //corresponds to y in omdbapi
  private int releaseYear;

  @SerializedName("Plot")
  //corresponds to plot in omdbapi
  private String plot;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(FilmLocation.class, id).toUri();
  }

}
