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

/** Defines workspace specific capabilities of the server.
  *
  * @since 3.18.0
  *
  * @param workspaceFolders
  *   The server supports workspace folder.
  *
  * since 3.6.0
  *
  * @param fileOperations
  *   The server is interested in notifications/requests for operations on
  *   files.
  *
  * since 3.16.0
  *
  * @param textDocumentContent
  *   The server supports the `workspace/textDocumentContent` request.
  *
  * since 3.18.0
  */
case class WorkspaceOptions(
    workspaceFolders: Option[structures.WorkspaceFoldersServerCapabilities] =
      None,
    fileOperations: Option[structures.FileOperationOptions] = None,
    textDocumentContent: Option[
      (structures.TextDocumentContentOptions |
        structures.TextDocumentContentRegistrationOptions)
    ] = None
)
object WorkspaceOptions extends codecs.structures_WorkspaceOptionsCodec
