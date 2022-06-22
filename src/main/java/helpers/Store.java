package helpers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "petId", "quantity", "shipDate", "status", "complete"})
public class Store {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

    public Store() {
        this.id = 0;
        this.petId = 0;
        this.quantity = 0;
        this.shipDate = "2022-06-18T14:47:32.562Z";
        this.status = "";
        this.complete = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }
}

