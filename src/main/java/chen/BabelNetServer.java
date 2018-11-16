package chen;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import chen.SenseFetcherServlet;
import it.uniroma1.lcl.babelnet.BabelNet;

public class BabelNetServer {
	public static BabelNet bn = BabelNet.getInstance();
	public static void main(String[] args) throws Exception {
		Server server = new Server(8779);
		ServletContextHandler handler = new ServletContextHandler(server, "/sense");
		handler.addServlet(SenseFetcherServlet.class, "/");
		server.start();
	}
}
