import org.junit.Test;


public class Testing extends BaseTest {
    @Test
    public void registroExitoso() {
        String firstName = "Jaime";
        String lastName = "Gallegos";
        String username = "jaime4";
        String email = "jaime@gmail.com";
        String password = "test1234";
        String phone = "8187980990";
        String birthdate = "25/01/2000";
        String cc = "3847759823476978";
        String expiration = "12/22";
        String cvv = "123";
        registrar.paginaRegistrar();
        registrar.registrar(firstName, lastName, username, email, password, phone, birthdate, cc, expiration, cvv);
    }

    @Test
    public void registroDuplicado() {
        String firstName = "Jaime";
        String lastName = "Gallegos";
        String username = "jaime3";
        String email = "jaime@gmail.com";
        String password = "test1234";
        String phone = "8187980990";
        String birthdate = "25/01/2000";
        String cc = "3847759823476978";
        String expiration = "12/22";
        String cvv = "123";
        registrar.paginaRegistrar();
        registrar.registrar(firstName, lastName, username, email, password, phone, birthdate, cc, expiration, cvv);
    }

    @Test
    public void login() {
        String username = "jaime1";
        String password = "test1234";
        login.login(username, password);
    }

    @Test
    public void loginIncorrecto() {
        String username = "";
        String password = "";
        login.login(username, password);
    }

    @Test
    public void compra() {
        String username = "jaime1";
        String password = "test1234";
        String simbolo = "AMZN";
        String cantidad = "1";
        login.login(username, password);
        compra.comprar(simbolo, cantidad);
    }

    @Test
    public void compraNegativa() {
        String username = "jaime1";
        String password = "test1234";
        String simbolo = "AMZN";
        String cantidad = "-2";
        login.login(username, password);
        compra.comprar(simbolo, cantidad);
    }

    @Test
    public void compraMayorAlPresupuesto() {
        String username = "jaime1";
        String password = "test1234";
        String simbolo = "AMZN";
        String cantidad = "300";
        login.login(username, password);
        compra.comprar(simbolo, cantidad);
    }

    @Test
    public void venderConUnaCantidadMayor() {
        String username = "jaime1";
        String password = "test1234";
        String cantidad = "300";
        login.login(username, password);
        Vender.vender(cantidad);
    }
}