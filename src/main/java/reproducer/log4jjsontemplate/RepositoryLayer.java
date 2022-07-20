package reproducer.log4jjsontemplate;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryLayer {

    public void doSomething() {
        throw new NullPointerException("RepositoryLayer.exception");
    }
}
