package pers.carl.iFindBook.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody {
    private Object responseData;
    private int responseCode;
}
