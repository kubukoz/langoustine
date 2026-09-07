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

/** Predefined Language kinds
  * @since 3.18.0
  */
opaque type LanguageKind = String
object LanguageKind
    extends StringEnum[LanguageKind]
    with CustomStringValues[LanguageKind]:
  val ABAP         = entry("abap")
  val WindowsBat   = entry("bat")
  val BibTeX       = entry("bibtex")
  val Clojure      = entry("clojure")
  val Coffeescript = entry("coffeescript")
  val C            = entry("c")
  val CPP          = entry("cpp")
  val CSharp       = entry("csharp")
  val CSS          = entry("css")

  /** @since 3.18.0
    */
  val D = entry("d")

  /** @since 3.18.0
    */
  val Delphi          = entry("pascal")
  val Diff            = entry("diff")
  val Dart            = entry("dart")
  val Dockerfile      = entry("dockerfile")
  val Elixir          = entry("elixir")
  val Erlang          = entry("erlang")
  val FSharp          = entry("fsharp")
  val GitCommit       = entry("git-commit")
  val GitRebase       = entry("git-rebase")
  val Go              = entry("go")
  val Groovy          = entry("groovy")
  val Handlebars      = entry("handlebars")
  val Haskell         = entry("haskell")
  val HTML            = entry("html")
  val Ini             = entry("ini")
  val Java            = entry("java")
  val JavaScript      = entry("javascript")
  val JavaScriptReact = entry("javascriptreact")
  val JSON            = entry("json")
  val LaTeX           = entry("latex")
  val Less            = entry("less")
  val Lua             = entry("lua")
  val Makefile        = entry("makefile")
  val Markdown        = entry("markdown")
  val ObjectiveC      = entry("objective-c")
  val ObjectiveCPP    = entry("objective-cpp")

  /** @since 3.18.0
    */
  val Pascal          = entry("pascal")
  val Perl            = entry("perl")
  val Perl6           = entry("perl6")
  val PHP             = entry("php")
  val Plaintext       = entry("plaintext")
  val Powershell      = entry("powershell")
  val Pug             = entry("jade")
  val Python          = entry("python")
  val R               = entry("r")
  val Razor           = entry("razor")
  val Ruby            = entry("ruby")
  val Rust            = entry("rust")
  val SCSS            = entry("scss")
  val SASS            = entry("sass")
  val Scala           = entry("scala")
  val ShaderLab       = entry("shaderlab")
  val ShellScript     = entry("shellscript")
  val SQL             = entry("sql")
  val Swift           = entry("swift")
  val TypeScript      = entry("typescript")
  val TypeScriptReact = entry("typescriptreact")
  val TeX             = entry("tex")
  val VisualBasic     = entry("vb")
  val XML             = entry("xml")
  val XSL             = entry("xsl")
  val YAML            = entry("yaml")
  override def ALL    = Set(
    ABAP,
    WindowsBat,
    BibTeX,
    Clojure,
    Coffeescript,
    C,
    CPP,
    CSharp,
    CSS,
    D,
    Delphi,
    Diff,
    Dart,
    Dockerfile,
    Elixir,
    Erlang,
    FSharp,
    GitCommit,
    GitRebase,
    Go,
    Groovy,
    Handlebars,
    Haskell,
    HTML,
    Ini,
    Java,
    JavaScript,
    JavaScriptReact,
    JSON,
    LaTeX,
    Less,
    Lua,
    Makefile,
    Markdown,
    ObjectiveC,
    ObjectiveCPP,
    Pascal,
    Perl,
    Perl6,
    PHP,
    Plaintext,
    Powershell,
    Pug,
    Python,
    R,
    Razor,
    Ruby,
    Rust,
    SCSS,
    SASS,
    Scala,
    ShaderLab,
    ShellScript,
    SQL,
    Swift,
    TypeScript,
    TypeScriptReact,
    TeX,
    VisualBasic,
    XML,
    XSL,
    YAML
  )
end LanguageKind
