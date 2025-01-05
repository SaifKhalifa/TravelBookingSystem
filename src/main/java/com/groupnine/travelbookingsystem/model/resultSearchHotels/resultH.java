package com.groupnine.travelbookingsystem.model.resultSearchHotels;

import javax.persistence.*;

@Entity
@Table(name = "hotelresults")
public class resultH{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id") // Updated to match the cards concept
    private int cardId;


    public resultH() {}

    public resultH(int cardId) {
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
        return "resultH{" +
                "cardId=" + cardId +
                '}';
    }
}
