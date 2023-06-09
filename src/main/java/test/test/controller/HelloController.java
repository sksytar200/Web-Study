package test.test.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
//        웹사이트에서 파라미터 받아오기
    }
    @GetMapping("hello-string")
    @ResponseBody
//    http에서 body부에 리턴 데이터를 직접 넣어주겠다는 의미
    public String helloStrong(@RequestParam("name") String name){
        return "hello" + name; // "hello spring" 으로 바뀜 내가 요청한 클라이언트에 그대로 내려감, 뷰 같은게 없이 그대로 내려감!!
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
