package ams.labs.entity;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Anvandare {

    @GraphId Long id;
    private Long anvandarId;

    @Relationship(type = "WATCHED_AT", direction = Relationship.OUTGOING)
    private List<Tittat> tittat = new ArrayList<>();

    @Relationship(type = "FAVORITE_MARKED", direction = Relationship.OUTGOING)
    private List<Favorit> favorits = new ArrayList<>();

    public Anvandare() { }

    public Long getAnvandarId() {
        return anvandarId;
    }

    public void setAnvandarId(Long anvandarId) {
        this.anvandarId = anvandarId;
    }

    public List<Tittat> getTittat() {
        return tittat;
    }

    public void setTittat(List<Tittat> tittat) {
        this.tittat = tittat;
    }

    public List<Favorit> getFavorits() {
        return favorits;
    }

    public void setFavorits(List<Favorit> favorits) {
        this.favorits = favorits;
    }
}
