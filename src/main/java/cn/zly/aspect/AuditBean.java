package cn.zly.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * 统计service执行时间
 */
@Component
@Aspect
public class AuditBean {

    @Around("within(cn.zly.service..*)")
    public Object audit(ProceedingJoinPoint point) {
        Object object = null;
        try {
            long timeStart = System.currentTimeMillis();
            object = point.proceed();
            long timeEnd = System.currentTimeMillis();
            String str = point.getSignature().toString();
            System.out.println(str + " 耗时：" + (timeEnd - timeStart));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        System.out.println("你好! !");
        PrintStream out = System.out;
        PrintStream fileOut = null;
        try {
            fileOut = new PrintStream(
                    new FileOutputStream("SystemOut.txt"));
            //将我们给定的输出流赋值到System.out上
            System.setOut(fileOut);
            System.setErr(fileOut);
            System.out.println("你好！ ！! 我是输出到控制台的！");
            System.setOut(out);
            System.out.println("我是输出到控制台的 ！");
//            fileOut.close();
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println("222");
            e.printStackTrace();
            // TODO Auto-generated catch block
        }
    }
}
