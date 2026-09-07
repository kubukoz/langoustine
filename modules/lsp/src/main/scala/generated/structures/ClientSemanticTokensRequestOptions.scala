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
  * @param range
  *   The client will send the `textDocument/semanticTokens/range` request if
  *   the server provides a corresponding handler.
  *
  * @param full
  *   The client will send the `textDocument/semanticTokens/full` request if the
  *   server provides a corresponding handler.
  */
case class ClientSemanticTokensRequestOptions(
    range: Option[(Boolean | ClientSemanticTokensRequestOptions.S0)] = None,
    full: Option[(Boolean | structures.ClientSemanticTokensRequestFullDelta)] =
      None
)
object ClientSemanticTokensRequestOptions
    extends codecs.structures_ClientSemanticTokensRequestOptionsCodec:
  case class S0(
  )
  object S0 extends codecs.structures_ClientSemanticTokensRequestOptions_S0Codec
