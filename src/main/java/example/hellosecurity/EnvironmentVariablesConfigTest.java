package example.hellosecurity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "hello.security")
@AllArgsConstructor
@Getter
@Setter
public class EnvironmentVariablesConfigTest {

    @NotNull
    private String myVar;

}
