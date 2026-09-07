/*
 * Copyright 2022 Neandertech
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

// format:off
package langoustine.lsp
package structures

import langoustine.*
import runtime.{*, given}

/** Client Capabilities for a {@link SignatureHelpRequest}.
  *
  * @param dynamicRegistration
  *   Whether signature help supports dynamic registration.
  *
  * @param signatureInformation
  *   The client supports the following `SignatureInformation` specific
  *   properties.
  *
  * @param contextSupport
  *   The client supports to send additional context information for a
  *   `textDocument/signatureHelp` request. A client that opts into
  *   contextSupport will also support the `retriggerCharacters` on
  *   `SignatureHelpOptions`.
  *
  * since 3.15.0
  */
case class SignatureHelpClientCapabilities(
    dynamicRegistration: Option[Boolean] = None,
    signatureInformation: Option[structures.ClientSignatureInformationOptions] =
      None,
    contextSupport: Option[Boolean] = None
)
object SignatureHelpClientCapabilities
    extends codecs.structures_SignatureHelpClientCapabilitiesCodec
