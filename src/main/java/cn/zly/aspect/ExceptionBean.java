package cn.zly.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常切面
 */
@Component //扫描到spring容器
@Aspect  //将该类作为切面组件
public class ExceptionBean {
    //    e是目标组件抛出的异常对象
    @AfterThrowing(throwing = "e", pointcut = "within(cn.zly.service..*)")
    public void execute(Exception e) {
        System.out.println("异常捕获");
//        将异常信息输入文件
        try {
            FileWriter fos = new FileWriter("D:/note_error.log", true);
            PrintWriter pw = new PrintWriter(fos, true);
//            利用pw对象写入异常信息
            Date time = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStr = sdf.format(time);
            String separator = StringUtils.leftPad("", 50, "*");
            pw.println(separator);
            pw.println("异常时间：" + timeStr);
            e.printStackTrace(pw);
            pw.println(separator);
            pw.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
