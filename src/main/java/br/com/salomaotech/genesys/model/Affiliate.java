package br.com.salomaotech.genesys.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_affiliate")
public class Affiliate implements Serializable {

    @Id
    private Long id;

    @OneToMany(mappedBy = "affiliate", cascade = CascadeType.ALL)
    private List<AffiliateProfit> affiliateProfits = new ArrayList<>();

    @OneToMany(mappedBy = "affiliate", cascade = CascadeType.ALL)
    private List<OrderNew> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AffiliateProfit> getAffiliateProfits() {
        return affiliateProfits;
    }

    public void setAffiliateProfits(List<AffiliateProfit> affiliateProfits) {
        this.affiliateProfits = affiliateProfits;
    }

    public List<OrderNew> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderNew> orders) {
        this.orders = orders;
    }

}
