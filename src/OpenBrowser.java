import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class OpenBrowser {
	
	public static void browser(){
	try {
		JsoupParse.getweb();
        URI uri = new URI(JsoupParse.getweb());
        java.awt.Desktop.getDesktop().browse(uri);
     
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (URISyntaxException ex) {
        ex.printStackTrace();
    }
}
}
