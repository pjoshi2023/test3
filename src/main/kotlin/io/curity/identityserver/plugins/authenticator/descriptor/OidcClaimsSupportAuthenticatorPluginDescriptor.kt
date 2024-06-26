/*
 * Copyright 2024 Curity AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.curity.identityserver.plugins.authenticator.descriptor

import io.curity.identityserver.plugins.authenticator.authentication.CallbackRequestHandler
import io.curity.identityserver.plugins.authenticator.authentication.ProviderConfigurationManagedObject
import io.curity.identityserver.plugins.authenticator.authentication.OidcClaimSupportAuthenticatorRequestHandler
import io.curity.identityserver.plugins.authenticator.config.OidcClaimsSupportAuthenticatorPluginConfig
import se.curity.identityserver.sdk.plugin.ManagedObject
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor
import java.util.Optional

class OidcClaimsSupportAuthenticatorPluginDescriptor : AuthenticatorPluginDescriptor<OidcClaimsSupportAuthenticatorPluginConfig> {

    override fun getPluginImplementationType() = "oidc-claims-support"

    override fun getConfigurationType() = OidcClaimsSupportAuthenticatorPluginConfig::class.java

    override fun getAuthenticationRequestHandlerTypes() = linkedMapOf(
        "index" to OidcClaimSupportAuthenticatorRequestHandler::class.java,
        CALLBACK to CallbackRequestHandler::class.java
    )

    override fun createManagedObject(configuration: OidcClaimsSupportAuthenticatorPluginConfig):
            Optional<out ManagedObject<OidcClaimsSupportAuthenticatorPluginConfig>> =
        Optional.of(ProviderConfigurationManagedObject(configuration))

    companion object {
        const val CALLBACK: String = "callback"
    }
}
