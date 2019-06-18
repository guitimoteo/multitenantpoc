package br.com.multitenant.config;
/*
*
import com.example.model.MongoAuthentication;
import com.example.model.UsernamePasswordMongoAuthentication;
import com.example.tenant.MongoConnectionCache;
*/
//import org.springframework.data.mongodb.core.MongoDbUtils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Caches initialized views of logical databases in a MongoDB cluster for faster access.
 */
@Component
@ApplicationScope
class CachedMongoConnector /*implements MongoConnector */{
/*
	private final TextEncryptor encryptor;
	private final MongoConnectionCache cache;

	@Autowired
	CachedMongoConnector(TextEncryptor encryptor, MongoConnectionCache cache) {
		this.encryptor = encryptor;
		this.cache = cache;
	}

	@Override
	public DB connect(MongoConnectionConfig connectionConfig, String dbName) {
		Assert.notNull(connectionConfig, "Mongo connection configuration must be specified");
		Assert.hasLength(connectionConfig.getHost(), "Mongo host must be specified");
		Assert.hasLength(dbName, "Mongo database to connect to must be specified");
		String configDbName = connectionConfig.getDbName();
		Assert.isTrue(
				dbName.equals(configDbName),
				String.format("Invalid Mongo database to connect to specified: \"%s\" vs. \"%s\"", dbName, configDbName)
		);

		Mongo mongoConnection = cache.get(connectionConfig, config -> initMongoConnection(config));

		return MongoDbUtils.getDB(mongoConnection, configDbName);
	}

	private Mongo initMongoConnection(MongoConnectionConfig mongoConfig) {
		MongoAuthentication mongoAuth = mongoConfig.getAuth();
		switch (mongoAuth.getType()) {
			case NONE:
				return initUnauthenticatedMongoConnection(mongoConfig);
			case USERNAME_PASSWORD:
				return initAuthenticatedMongoConnection(mongoConfig);
			default:
				throw new IllegalArgumentException("Unsupported Mongo authentication type: " + mongoAuth.getType());
		}
	}

	private Mongo initUnauthenticatedMongoConnection(MongoConnectionConfig mongoConfig) {
		return new MongoClient(mongoConfig.getHost(), mongoConfig.getPort());
	}

	private Mongo initAuthenticatedMongoConnection(MongoConnectionConfig mongoConfig) {
		UsernamePasswordMongoAuthentication mongoAuth = (UsernamePasswordMongoAuthentication) mongoConfig.getAuth();
		String userName = mongoAuth.getUserName();
		String password = mongoAuth.getPassword();
		String decryptedUserName = encryptor.decrypt(userName);
		String decryptedPassword = encryptor.decrypt(password);
		MongoCredential credential = MongoCredential.createCredential(
				decryptedUserName,
				mongoConfig.getDbName(),
				decryptedPassword.toCharArray()
		);
		ServerAddress serverAddress = new ServerAddress(mongoConfig.getHost(), mongoConfig.getPort());
		return new MongoClient(serverAddress, Collections.singletonList(credential));
	}
*/
}
