package chen;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import chen.SenseFetcherServlet;
import it.uniroma1.lcl.babelnet.BabelNet;
import chen.WNIdSenseFetcherServlet;

public class BabelNetServer {
	public static BabelNet bn = BabelNet.getInstance();

	public static void main(String[] args) throws Exception {
		Server server = new Server(8779);
		ServletContextHandler context = new ServletContextHandler(server, "/");
		context.addServlet(SenseFetcherServlet.class, "/sense/*");
		context.addServlet(WNIdSenseFetcherServlet.class, "/wnid/*");
		server.start();
	}
}
