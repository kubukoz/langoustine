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

/** The Client Capabilities of a {@link CodeActionRequest}.
  *
  * @param dynamicRegistration
  *   Whether code action supports dynamic registration.
  *
  * @param codeActionLiteralSupport
  *   The client support code action literals of type `CodeAction` as a valid
  *   response of the `textDocument/codeAction` request. If the property is not
  *   set the request can only return `Command` literals.
  *
  * since 3.8.0
  *
  * @param isPreferredSupport
  *   Whether code action supports the `isPreferred` property.
  *
  * since 3.15.0
  *
  * @param disabledSupport
  *   Whether code action supports the `disabled` property.
  *
  * since 3.16.0
  *
  * @param dataSupport
  *   Whether code action supports the `data` property which is preserved
  *   between a `textDocument/codeAction` and a `codeAction/resolve` request.
  *
  * since 3.16.0
  *
  * @param resolveSupport
  *   Whether the client supports resolving additional code action properties
  *   via a separate `codeAction/resolve` request.
  *
  * since 3.16.0
  *
  * @param honorsChangeAnnotations
  *   Whether the client honors the change annotations in text edits and
  *   resource operations returned via the `CodeAction#edit` property by for
  *   example presenting the workspace edit in the user interface and asking for
  *   confirmation.
  *
  * since 3.16.0
  *
  * @param documentationSupport
  *   Whether the client supports documentation for a class of code actions.
  *
  * since 3.18.0
  *
  * @param tagSupport
  *   Client supports the tag property on a code action. Clients supporting tags
  *   have to handle unknown tags gracefully.
  *
  * since 3.18.0
  */
case class CodeActionClientCapabilities(
    dynamicRegistration: Option[Boolean] = None,
    codeActionLiteralSupport: Option[
      structures.ClientCodeActionLiteralOptions
    ] = None,
    isPreferredSupport: Option[Boolean] = None,
    disabledSupport: Option[Boolean] = None,
    dataSupport: Option[Boolean] = None,
    resolveSupport: Option[structures.ClientCodeActionResolveOptions] = None,
    honorsChangeAnnotations: Option[Boolean] = None,
    documentationSupport: Option[Boolean] = None,
    tagSupport: Option[structures.CodeActionTagOptions] = None
)
object CodeActionClientCapabilities
    extends codecs.structures_CodeActionClientCapabilitiesCodec
