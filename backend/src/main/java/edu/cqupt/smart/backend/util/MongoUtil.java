package edu.cqupt.smart.backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Package_Name: edu.cqupt.smart.backend.pojo
 * @Description: TODO
 * @Date: 2024/2/21 1:43
 * @Created: SiriAo
 */
@Data
@AllArgsConstructor
public class MongoUtil {
    // bug:当前面删除后id会占用已经使用过的id
    private Long docCount;

    public void selfIncrease() {
        this.docCount++;
    }
}
