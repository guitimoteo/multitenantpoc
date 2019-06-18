package br.com.multitenant.config;
/**
 * {@link InheritableThreadLocal}-based holder for the to use
 * during request processing.
 */
public class CurrentMongoConfigHolder {
/*
	private static final ThreadLocal<MongoConnectionConfig> CURRENT_CONFIG = new InheritableThreadLocal<>();

	public static MongoConnectionConfig get() {
		return CURRENT_CONFIG.get();
	}

	public static void set(MongoConnectionConfig mongoConfig) {
		CURRENT_CONFIG.set(mongoConfig);
	}

	public static MongoConnectionConfig remove() {
		synchronized (CURRENT_CONFIG) {
			MongoConnectionConfig currentConfig = get();
			CURRENT_CONFIG.remove();
			return currentConfig;
		}
	}
	*/
}