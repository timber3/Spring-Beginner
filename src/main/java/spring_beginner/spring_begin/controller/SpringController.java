package spring_beginner.spring_begin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "nana", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody // 순수 data 만 그대로 클라이언트에게 전달해줌
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    static class Hello {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

    // 아래와 같이 객체를 전달하게 되면 Json 형식으로 전달하게 됨
    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }
}
