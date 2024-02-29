package kz.iitu.detector.domain.purchase;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private Long userId;
    private Long time;

    public Purchase(Long userId, Long time) {
        this.userId = userId;
        this.time = time;
    }
}
