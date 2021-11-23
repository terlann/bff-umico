package az.kapitalbank.bffumico.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.vault.config.SecretBackendConfigurer;
import org.springframework.cloud.vault.config.VaultConfigurer;
import org.springframework.cloud.vault.config.VaultKeyValueBackendProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VaultConfig implements VaultConfigurer {

    VaultKeyValueBackendProperties vaultKeyValueBackendProperties;

    @Override
    public void addSecretBackends(SecretBackendConfigurer configurer) {
        var backend = vaultKeyValueBackendProperties.getBackend();
        var contextPath = vaultKeyValueBackendProperties.getDefaultContext();
        var applicationName = vaultKeyValueBackendProperties.getApplicationName();
        var profileSeparator = vaultKeyValueBackendProperties.getProfileSeparator();
        var profile = vaultKeyValueBackendProperties.getProfiles().get(0);

        var path = String.join(profileSeparator, backend, contextPath, applicationName, profile);
        log.info("Vault path: {}", path);
        configurer.add(path);

        configurer.registerDefaultKeyValueSecretBackends(false);
        configurer.registerDefaultDiscoveredSecretBackends(true);
    }
}
