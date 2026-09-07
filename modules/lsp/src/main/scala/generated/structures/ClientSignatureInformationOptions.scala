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

/** @since 3.18.0
  *
  * @param documentationFormat
  *   Client supports the following content formats for the documentation
  *   property. The order describes the preferred format of the client.
  *
  * @param parameterInformation
  *   Client capabilities specific to parameter information.
  *
  * @param activeParameterSupport
  *   The client supports the `activeParameter` property on
  *   `SignatureInformation` literal.
  *
  * since 3.16.0
  *
  * @param noActiveParameterSupport
  *   The client supports the `activeParameter` property on
  *   `SignatureHelp`/`SignatureInformation` being set to `null` to indicate
  *   that no parameter should be active.
  *
  * since 3.18.0
  */
case class ClientSignatureInformationOptions(
    documentationFormat: Option[Vector[enumerations.MarkupKind]] = None,
    parameterInformation: Option[
      structures.ClientSignatureParameterInformationOptions
    ] = None,
    activeParameterSupport: Option[Boolean] = None,
    noActiveParameterSupport: Option[Boolean] = None
)
object ClientSignatureInformationOptions
    extends codecs.structures_ClientSignatureInformationOptionsCodec
