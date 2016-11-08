package de.mvitz.spring.boot.thymeleaf.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class MyController {

    @GetMapping("/foo")
    public String foo() {
        throw new IllegalStateException("Foo");
    }

    @GetMapping("/bar")
    public String bar() {
        return "bar";
    }

    @GetMapping("/baz")
    public String baz() {
        throw new MyRuntimeException();
    }

    @GetMapping("/boo")
    public String boo() {
        throw new MySecondRuntimeException();
    }
}
