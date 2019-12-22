
package sec.project.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PlaintextEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence cs) {
        return cs.toString();
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        return string.equals(cs);
    }
    
}
