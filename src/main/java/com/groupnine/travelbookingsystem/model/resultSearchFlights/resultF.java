package com.groupnine.travelbookingsystem.model.resultSearchFlights;

import javax.persistence.*;

@Entity
@Table(name = "flightresults")
public class resultF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id") // Updated to match the cards concept
    private int cardId;

    public void resultF() {}

    public void resultF(int cardId) {
        this.cardId = cardId;
    }


    public int getCardId() {
        return cardId;
    }


    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "resultF{" +
                "cardId=" + cardId +
                '}';
    }
}

