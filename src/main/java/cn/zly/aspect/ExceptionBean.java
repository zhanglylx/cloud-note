package cn.zly.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 异常切面
 */
@Component //扫描到spring容器
@Aspect  //将该类作为切面组件
public class ExceptionBean {

    public void execute(){

    }
}
