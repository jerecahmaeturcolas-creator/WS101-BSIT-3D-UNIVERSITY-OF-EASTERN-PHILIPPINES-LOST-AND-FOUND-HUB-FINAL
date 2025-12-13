package Project.LostAndFound.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "found_items")
public class FoundItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private String location;
    private String finderName;
    private LocalDate foundDate;
    private String contactInfo;

    // Default constructor (REQUIRED by JPA)
    public FoundItem() {
    }

    // Constructor with all parameters
    public FoundItem(String itemName, String description, String location,
                     String finderName, LocalDate foundDate, String contactInfo) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.finderName = finderName;
        this.foundDate = foundDate;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters (REQUIRED)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFinderName() {
        return finderName;
    }

    public void setFinderName(String finderName) {
        this.finderName = finderName;
    }

    public LocalDate getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(LocalDate foundDate) {
        this.foundDate = foundDate;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}