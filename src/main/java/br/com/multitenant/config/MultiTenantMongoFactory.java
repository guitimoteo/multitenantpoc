package br.com.multitenant.config;

import br.com.multitenant.service.CatalogService;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

@Slf4j
public class MultiTenantMongoFactory extends SimpleMongoDbFactory {

	@Autowired
	private CatalogService catalogService;

	public MultiTenantMongoFactory(MongoClientURI uri) {
		super(uri);
	}

	@Override
	public MongoDatabase getDb() throws DataAccessException {
		// Check the RequestContext
		log.info("MultiTenantMongoFactory");
		return Optional.of(RequestContextHolder.getRequestAttributes().getAttribute("tenantId", RequestAttributes.SCOPE_REQUEST))
					   .filter(t -> t instanceof String)
					   .map(t -> getDb(catalogService.findDatabase(Long.valueOf(t.toString()))))
				       .get();
	}
}