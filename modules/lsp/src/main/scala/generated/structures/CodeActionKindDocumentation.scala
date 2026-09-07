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

/** Documentation for a class of code actions.
  *
  * @since 3.18.0
  *
  * @param kind
  *   The kind of the code action being documented.
  *
  * If the kind is generic, such as `CodeActionKind.Refactor`, the documentation
  * will be shown whenever any refactorings are returned. If the kind if more
  * specific, such as `CodeActionKind.RefactorExtract`, the documentation will
  * only be shown when extract refactoring code actions are returned.
  *
  * @param command
  *   Command that is ued to display the documentation to the user.
  *
  * The title of this documentation code action is taken from
  * {@linkcode Command.title}
  */
case class CodeActionKindDocumentation(
    kind: enumerations.CodeActionKind,
    command: structures.Command
)
object CodeActionKindDocumentation
    extends codecs.structures_CodeActionKindDocumentationCodec
