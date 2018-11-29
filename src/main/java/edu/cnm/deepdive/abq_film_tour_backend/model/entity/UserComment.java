package edu.cnm.deepdive.abq_film_tour_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class UserComment {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    UserComment.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_comment_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @NonNull
  @Column(length = 4096, nullable = false)
  private String text;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "film_location_id", nullable = false, updatable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private FilmLocation filmLocation;

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  @Transient
  private UUID userId;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private GoogleUser user;

  public GoogleUser getUser() {
    return user;
  }

  public void setUser(GoogleUser user) {
    this.user = user;
  }

  public UUID getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public FilmLocation getFilmLocation() {
    return filmLocation;
  }

  public void setFilmLocation(
      FilmLocation filmlocation) {
    this.filmLocation = filmlocation;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(FilmLocation.class, id).toUri();
  }
}
