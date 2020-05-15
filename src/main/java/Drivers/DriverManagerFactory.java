package Drivers;


public class DriverManagerFactory {

    public enum DriverType {
        CHROME,
        FIREFOX,
        SAFARI;
    }

    public static DriverManager getManager(DriverType type) {
    DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;

    }
}
