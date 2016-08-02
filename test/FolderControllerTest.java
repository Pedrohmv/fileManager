import org.junit.After;
import org.junit.Before;
import play.Application;
import play.test.Helpers;

public class FolderControllerTest {
    Application fakeApp = Helpers.fakeApplication();

    @Before
    public void setup() {
        Helpers.start(fakeApp);
    }

    @After
    public void teardown() {
        Helpers.stop(fakeApp);
    }
}
