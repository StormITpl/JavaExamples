package hello;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.hotspot.DefaultExports;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/metrics")
public class PrometheusServlet extends HttpServlet {

	@PostConstruct
	public void init() {
		DefaultExports.initialize();
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			io.prometheus.client.exporter.common.TextFormat.write004(
					writer, CollectorRegistry.defaultRegistry.metricFamilySamples());
		} catch (Exception e) {
			writer.println(e.getMessage());
		}
	}
}
