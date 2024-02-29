package kz.iitu.detector.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetectResponse {

    private Long id;
    private Long time;
    private String content;
    private DetectPercentsResponse detectPercentsResponse;

}
