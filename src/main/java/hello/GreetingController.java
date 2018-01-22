package hello;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@AuthenticationPrincipal final UserDetails userDetail, @RequestParam(value="name", defaultValue="World") String name) {
       /* String userName = userDetail.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
        authorities.forEach(System.out::println);*/
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/addgreeting", method = RequestMethod.PUT)
    public String addGreeting(@RequestBody Greeting name) {
        return "Added "+ String.valueOf(name.getId())+" "+name.getContent();
    }

}
