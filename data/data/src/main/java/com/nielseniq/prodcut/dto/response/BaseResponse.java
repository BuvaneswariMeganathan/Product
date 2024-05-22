package com.nielseniq.prodcut.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {
    public String infoId;
    public String infoMsg;
}
