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

/** The parameters of a {@link WorkspaceSymbolRequest}.
  *
  * @param query
  *   A query string to filter symbols by. Clients may send an empty string here
  *   to request all symbols.
  *
  * The `query`-parameter should be interpreted in a *relaxed way* as editors
  * will apply their own highlighting and scoring on the results. A good rule of
  * thumb is to match case-insensitive and to simply check that the characters
  * of *query* appear in their order in a candidate symbol. Servers shouldn't
  * use prefix, substring, or similar strict matching.
  *
  * @param workDoneToken
  *   An optional token that a server can use to report work done progress.
  *
  * @param partialResultToken
  *   An optional token that a server can use to report partial results (e.g.
  *   streaming) to the client.
  */
case class WorkspaceSymbolParams(
    query: String,
    workDoneToken: Option[aliases.ProgressToken] = None,
    partialResultToken: Option[aliases.ProgressToken] = None
)
object WorkspaceSymbolParams
    extends codecs.structures_WorkspaceSymbolParamsCodec
