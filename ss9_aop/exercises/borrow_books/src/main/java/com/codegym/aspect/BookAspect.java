package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    private static long count;
    @AfterThrowing("execution(* com.codegym.controller.BookController.orderBook(..))")
    public void checkOder() {
        System.out.println("----------------------------------");
        System.out.println("Không còn sách để mượn");
    }

    @After("execution(* com.codegym.controller.BookController.orderBook(..))")
    public void logOderDone() {
        System.out.println("----------------------------------");
        System.out.println("Mượn Sách Thành Công");
    }

    @After("execution(* com.codegym.controller.BookController.returnBook(..))")
    public void loggerPay() {
        System.out.println("----------------------------------");
        System.out.println("Trả sách thành công");
    }

    @After("execution(* com.codegym.controller.BookController.*(..))")
    public void logAfterMethodBookController(JoinPoint joinPoint) {
        count++;
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println("--------------------------------");
        System.out.println("Người truy cập phương thức " + nameMethod + " vào lúc: " + LocalDateTime.now());
        System.out.println("Số lượt truy cập: "+ count);
    }

}
