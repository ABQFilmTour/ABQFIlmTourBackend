package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

/**
 * This entity represents a film or television series with an entry on IMDb. Fields are serialized
 * to be imported directly from the OMDb API.
 */
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

  /**
   * The 7 digit String ID starting with "tt", corresponds to i in omdbapi
   */
  @Column(unique = true)
  @SerializedName("imdbID")
  private String imdbId;

  /**
   * The title of the production, corresponds to t in omdbapi
   */
  @SerializedName("Title")
  private String title;

  /**
   * The type of production, corresponds to "type" in omdbapi. Valid options - movie, series, episode
   */
  @SerializedName("Type")
  private String type;

  /**
   * The release year of the production, corresponds to y in omdbapi. String as this can cover a
   * range e.g 2008-2010
   */
  @SerializedName("Year")
  //corresponds to y in omdbapi
  private String releaseYear;

  /**
   * A plot summary of the production, corresponds to plot in omdbapi. 300 character max.
   */
  @Column(length = 300)
  @SerializedName("Plot")
  private String plot;

  /**
   * Gets id.
   *
   * @return the id
   */
  @ApiOperation(value = "Gets production Id", notes = "returns Id")
  public UUID getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  @ApiOperation(value = "Sets production Id", notes = "returns this Id")
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Gets imdb id.
   *
   * @return the imdb id
   */
  @ApiOperation(value = "Gets imdb Id", notes = "returns imdbId")
  public String getImdbId() {
    return imdbId;
  }

  /**
   * Sets imdb id.
   *
   * @param imdbId the imdb id
   */
  @ApiOperation(value = "Sets imdbId to a string", notes = "returns this imdbId and sets it to imdbId")
  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  /**
   * Gets title.
   *
   * @return the title
   */
  @ApiOperation(value = "Gets production title", notes = "returns title")
  public String getTitle() {
    return title;
  }

  /**
   * Sets title.
   *
   * @param title the title
   */
  @ApiOperation(value = "Sets title to string.", notes = "returns this title and sets it to title")
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets type. Valid options - movie, series, episode.
   *
   * @return a type of movie, series, or episode.
   */
  @ApiOperation(value = "Gets valid string type", notes = "returns this type")
  public String getType() {
    return type;
  }

  /**
   * Sets type. Valid options - movie, series, episode.
   *
   * @param type a type of movie, series, or episode.
   */
  @ApiOperation(value = "Set valid options", notes = "a type of movie, series or episode")
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Gets release year. May be represented as a range of years.
   *
   * @return the release year
   */
  @ApiOperation(value = "Gets release year", notes = "returns release year")
  public String getReleaseYear() {
    return releaseYear;
  }

  /**
   * Sets release year. May be represented as a range of years.
   *
   * @param releaseYear the release year
   */
  @ApiOperation(value = "Sets release year", notes = "sets this release year")
  public void setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
  }

  /**
   * Gets short plot information. Maximum of 300 characters.
   *
   * @return plot information.
   */
  @ApiOperation(value = "Sets plot information", notes = "returns plot information")
  public String getPlot() {
    return plot;
  }

  /**
   * Sets short plot information. Maximum of 300 characters.
   *
   * @param plot plot information.
   */
  @ApiOperation(value = "Sets plot information", notes = "sets this plot")
  public void setPlot(String plot) {
    this.plot = plot;
  }

  /**
   * Gets href.
   *
   * @return the href
   */
  @ApiOperation(value = "Gets Href", notes = "returns href link")
  public URI getHref() {
    return entityLinks.linkForSingleResource(FilmLocation.class, id).toUri();
  }

}
