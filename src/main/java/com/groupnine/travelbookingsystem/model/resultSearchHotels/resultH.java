package com.groupnine.travelbookingsystem.model.resultSearchHotels;

import javax.persistence.*;

@Entity
@Table(name = "hotelresults")
public class resultH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    private static String destination;

    // Default constructor
    public resultH() {}

    // Constructor with cardId parameter
    public resultH(int cardId) {
        this.cardId = cardId;
    }

    // Static getter for destination
    public static String getDestination() {
        return destination;
    }

    // Static setter for destination
    public static void setDestination(String destination) {
        resultH.destination = destination;
    }

    // Getter for cardId
    public int getCardId() {
        return cardId;
    }

    // Setter for cardId
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    // toString method for better debugging and logging
    @Override
    public String toString() {
        return "resultH{" +
                "cardId=" + cardId +
                ", destination='" + destination + '\'' +
                '}';
    }
}
