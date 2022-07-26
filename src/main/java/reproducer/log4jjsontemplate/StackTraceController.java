package reproducer.log4jjsontemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackTraceController {
    private static final Logger logger = LoggerFactory.getLogger(StackTraceController.class);

    private final ServiceLayer serviceLayer;

    public StackTraceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping
    public void test() {
        try {
            try {
                throw new NullPointerException("original error");
            } catch (Exception e) {
                throw new IllegalArgumentException("wrapper error", e);
            }
        } catch (Exception e) {
            logger.error("error", e);
        }
    }

    @GetMapping("/multi")
    public void testMulti() {
        try {
            try {
                serviceLayer.doSomething();
            } catch (Exception e) {
                throw new IllegalArgumentException("StackTraceController.exception", e);
            }
        } catch (Exception e) {
            logger.error("error", e);
        }
    }
}
