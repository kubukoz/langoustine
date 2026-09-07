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
package aliases

import langoustine.*
import runtime.{*, given}
import io.circe.*
import scala.reflect.*

/** The document diagnostic report used when reporting partial result.
  *
  * When using partial results, the first literal sent needs to be a
  * DocumentDiagnosticReport providing the diagnostics on the document followed
  * by n DocumentDiagnosticReportPartialResult literals providing the
  * diagnostics for related documents.
  *
  * ```
  * DocumentDiagnosticReport
  * DocumentDiagnosticReportPartialResult
  * DocumentDiagnosticReportPartialResult
  * ...
  * ```
  *
  * @since 3.18.1
  */
opaque type DocumentDiagnosticReportProgress =
  (aliases.DocumentDiagnosticReport |
    structures.DocumentDiagnosticReportPartialResult)
object DocumentDiagnosticReportProgress
    extends codecs.aliases_DocumentDiagnosticReportProgress:
  inline def apply(
      v: aliases.DocumentDiagnosticReport
  ): DocumentDiagnosticReportProgress = v
  inline def apply(
      v: structures.DocumentDiagnosticReportPartialResult
  ): DocumentDiagnosticReportProgress = v

  extension (v: DocumentDiagnosticReportProgress)
    inline def value: (aliases.DocumentDiagnosticReport |
      structures.DocumentDiagnosticReportPartialResult) = v

  given Typeable[DocumentDiagnosticReportProgress] with
    def unapply(s: Any): Option[s.type & DocumentDiagnosticReportProgress] =
      s match
        case c: aliases.DocumentDiagnosticReport =>
          Some(c.asInstanceOf[s.type & aliases.DocumentDiagnosticReport])
        case c: structures.DocumentDiagnosticReportPartialResult =>
          Some(
            c.asInstanceOf[
              s.type & structures.DocumentDiagnosticReportPartialResult
            ]
          )
        case _ => Option.empty
  end given
end DocumentDiagnosticReportProgress
