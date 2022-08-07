package authorization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel <T>{

    private int status;
    private Boolean isSuccess;
    private String message;
    private T data;

    public void setError(String mes){
        message = mes;
        isSuccess = false;
        status = 400;
    }

    public void  setSuccess(T item){
        data = item;
        isSuccess = true;
        status = 200;
    }
}
