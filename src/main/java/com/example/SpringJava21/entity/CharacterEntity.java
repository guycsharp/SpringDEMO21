package com.example.SpringJava21.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "charactermain")  // adjust to your actual table name
public class CharacterEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "FullName")
        private String fullName;

        @Column(name = "Faction")
        private String faction;

        @Column(name = "updateDate")
        private LocalDateTime updateDate;

        @Column(name = "insertedDate")
        private LocalDateTime insertedDate;

        @Column(name = "pic")
        private String pic;

        @Column(name = "type")
        private String type;

        @Column(name = "allegiance")
        private Integer allegiance;

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getFaction() { return faction; }
    public void setFaction(String faction) { this.faction = faction; }

    public LocalDateTime getUpdateDate() { return updateDate; }
    public void setUpdateDate(LocalDateTime updateDate) { this.updateDate = updateDate; }

    public LocalDateTime getInsertedDate() { return insertedDate; }
    public void setInsertedDate(LocalDateTime insertedDate) { this.insertedDate = insertedDate; }

    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Integer getAllegiance() { return allegiance; }
    public void setAllegiance(Integer allegiance) { this.allegiance = allegiance; }
}
