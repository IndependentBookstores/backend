package com.example.bookstore.payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private String status;
    private String message;
    private Object data;

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        System.out.println(data);
        ObjectMapper mapper = new ObjectMapper();

//        JSONParser jsonParser = new JSONParser();
//        (JSONObject) jsonParser.parse(data);
        try {
            this.data = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
