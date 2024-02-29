package kz.iitu.detector.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetectPercentsResponse {

    private Integer ai;
    private Integer human;
    private Integer plagiarism;

}
