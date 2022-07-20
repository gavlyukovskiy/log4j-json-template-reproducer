package reproducer.log4jjsontemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    private final RepositoryLayer repositoryLayer;

    public ServiceLayer(RepositoryLayer repositoryLayer) {
        this.repositoryLayer = repositoryLayer;
    }

    public void doSomething() {
        try {
            repositoryLayer.doSomething();
        } catch (Exception e) {
            throw new IllegalStateException("ServiceLayer.exception", e);
        }
    }
}
