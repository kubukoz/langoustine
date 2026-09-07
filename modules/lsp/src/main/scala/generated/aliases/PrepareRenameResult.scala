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

opaque type PrepareRenameResult =
  (structures.Range | structures.PrepareRenamePlaceholder |
    structures.PrepareRenameDefaultBehavior)
object PrepareRenameResult extends codecs.aliases_PrepareRenameResult:
  inline def apply(v: structures.Range): PrepareRenameResult = v
  inline def apply(
      v: structures.PrepareRenamePlaceholder
  ): PrepareRenameResult = v
  inline def apply(
      v: structures.PrepareRenameDefaultBehavior
  ): PrepareRenameResult = v

  extension (v: PrepareRenameResult)
    inline def value: (structures.Range | structures.PrepareRenamePlaceholder |
      structures.PrepareRenameDefaultBehavior) = v

  given Typeable[PrepareRenameResult] with
    def unapply(s: Any): Option[s.type & PrepareRenameResult] =
      s match
        case c: structures.Range =>
          Some(c.asInstanceOf[s.type & structures.Range])
        case c: structures.PrepareRenamePlaceholder =>
          Some(c.asInstanceOf[s.type & structures.PrepareRenamePlaceholder])
        case c: structures.PrepareRenameDefaultBehavior =>
          Some(c.asInstanceOf[s.type & structures.PrepareRenameDefaultBehavior])
        case _ => Option.empty
  end given
end PrepareRenameResult
