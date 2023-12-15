@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_raffle")
public class Raffle {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private List<AffiliateProfit> affiliateProfits = new ArrayList<>();
}

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_affiliate")
public class Affiliate extends Person {
    @OneToMany(mappedBy = "affiliate", cascade = CascadeType.ALL)
    private List<AffiliateProfit> affiliateProfits = new ArrayList<>();

    @OneToMany(mappedBy = "affiliate", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_order")
public class Order extends AbstractAggregateRoot<Order> {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "raffle_id", nullable = false)
    private Raffle raffle;

    @ManyToOne
    @JoinColumn(name = "affiliate_id", nullable = false)
    private Affiliate affiliate;
}

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_affiliate_profit")
public class AffiliateProfit {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "raffle_id", nullable = false)
    private Raffle raffle;

    @ManyToOne
    @JoinColumn(name = "affiliate_id", nullable = false)
    private Affiliate affiliate;
}