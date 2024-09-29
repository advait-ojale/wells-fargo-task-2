package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    protected Portfolio() {
    }

    public Portfolio(Client client) {
        this.client = client;
    }

    // Getters and Setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}

