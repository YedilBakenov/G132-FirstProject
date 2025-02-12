package kz.first_project.g132.component;


import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("request")
@Getter
public class PrototypeComponent {

    private String id = UUID.randomUUID().toString();



}
