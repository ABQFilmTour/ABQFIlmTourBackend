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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Image {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Image.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "image_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;


  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "film_location_id", nullable = false, updatable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private FilmLocation filmlocation;

  public Image(){
    //empty constructor
  }

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  public UUID getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public FilmLocation getFilmlocation() {
    return filmlocation;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public void setFilmlocation(
      FilmLocation filmlocation) {
    this.filmlocation = filmlocation;
  }

  public URI getHref(){return entityLinks.linkForSingleResource(Image.class, id).toUri();}


}