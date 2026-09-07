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

package langoustine.lsp
package enumerations

import runtime.{*, given}
import io.circe.*
import scala.reflect.Typeable
import scala.annotation.switch

/** Defines how values from a set of defaults and an individual item will be
  * merged.
  *
  * @since 3.18.0
  */
opaque type ApplyKind = runtime.uinteger
object ApplyKind extends UIntEnum[ApplyKind]:
  /** The value from the individual item (if provided and not `null`) will be
    * used instead of the default.
    */
  val Replace = entry(1)

  /** The value from the item will be merged with the default.
    *
    * The specific rules for mergeing values are defined against each field that
    * supports merging.
    */
  val Merge        = entry(2)
  override def ALL = Set(
    Replace,
    Merge
  )

  extension (self: ApplyKind)
    def name: String = (self.value: @switch) match
      case 1 => "Replace"
      case 2 => "Merge"
end ApplyKind
