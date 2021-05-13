package com.zn.springCloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResule<T> {
    private Integer code;
    private String Message;

    private T date;

    private CommentResule(Integer code,String message){
        this(code,message,null);
    }
}
