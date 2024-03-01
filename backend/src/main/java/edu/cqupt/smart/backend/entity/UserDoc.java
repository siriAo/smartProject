package edu.cqupt.smart.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;


/**
 * @Package_Name: edu.cqupt.smart.backend.entity
 * @Description: TODO
 * @Date: 2024/2/19 18:12
 * @Created: SiriAo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "test")
public class UserDoc {
    @MongoId
    private Long id;
    @Field("userId")
    private Long userId;
    @Field("title")
    private String title;
    @Field("content")
    private String content;

    public UserDoc(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
