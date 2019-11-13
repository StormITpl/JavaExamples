package hello;

//import com.codahale.metrics.MetricRegistry;
//import io.prometheus.client.CollectorRegistry;
//import io.prometheus.client.dropwizard.DropwizardExports;
//import io.prometheus.client.hotspot.MemoryPoolsExports;
//import io.prometheus.client.hotspot.StandardExports;
//import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;

//@Configuration
//@EnablePrometheusEndpoint
public class PrometheusConfiguration {

//	private MetricRegistry dropwizardMetricRegistry;
//
//	@Autowired
//	public PrometheusConfiguration(MetricRegistry dropwizardMetricRegistry) {
//		this.dropwizardMetricRegistry = dropwizardMetricRegistry;
//	}
//
//	@PostConstruct
//	public void registerPrometheusCollectors() {
//		CollectorRegistry.defaultRegistry.clear();
//		new StandardExports().register();
//		new MemoryPoolsExports().register();
//		new DropwizardExports(dropwizardMetricRegistry).register();
//
//	}
}