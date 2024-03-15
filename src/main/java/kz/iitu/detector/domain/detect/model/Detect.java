package kz.iitu.detector.domain.detect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detect")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long time;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Integer ai;
    private Integer human;
    private Integer plagiarism;

    public Detect(Long userId, Long time, String content, Integer ai, Integer human, Integer plagiarism) {
        this.userId = userId;
        this.time = time;
        this.content = content;
        this.ai = ai;
        this.human = human;
        this.plagiarism = plagiarism;
    }
}
