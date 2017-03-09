package com.tim.springEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** alt+insert get.set方法
 * Created by Admin on 2017/3/7.
 */
@Service
public class DemoService {

    @Value("其他的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
