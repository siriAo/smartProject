package edu.cqupt.smart.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @Package_Name: edu.cqupt.smart.backend.entity
 * @Description: TODO
 * @Date: 2024/2/19 18:16
 * @Created: SiriAo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "wuHan")
public class WuHanDoc {
    @MongoId
    @Field("queryCode")
    private Long queryCode;
    @NonNull
    @Field("title")
    private String title;
    @NonNull
    @Field("content")
    private String content;
    @Field("asContent")
    private String asContent;

}
