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

/** Client capabilities for a {@link WorkspaceSymbolRequest}.
  *
  * @param dynamicRegistration
  *   Symbol request supports dynamic registration.
  *
  * @param symbolKind
  *   Specific capabilities for the `SymbolKind` in the `workspace/symbol`
  *   request.
  *
  * @param tagSupport
  *   The client supports tags on `SymbolInformation`. Clients supporting tags
  *   have to handle unknown tags gracefully.
  *
  * since 3.16.0
  *
  * @param resolveSupport
  *   The client support partial workspace symbols. The client will send the
  *   request `workspaceSymbol/resolve` to the server to resolve additional
  *   properties.
  *
  * since 3.17.0
  */
case class WorkspaceSymbolClientCapabilities(
    dynamicRegistration: Option[Boolean] = None,
    symbolKind: Option[structures.ClientSymbolKindOptions] = None,
    tagSupport: Option[structures.ClientSymbolTagOptions] = None,
    resolveSupport: Option[structures.ClientSymbolResolveOptions] = None
)
object WorkspaceSymbolClientCapabilities
    extends codecs.structures_WorkspaceSymbolClientCapabilitiesCodec
