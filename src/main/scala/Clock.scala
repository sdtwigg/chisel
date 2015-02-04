/*
 Copyright (c) 2011, 2012, 2013, 2014 The Regents of the University of
 California (Regents). All Rights Reserved.  Redistribution and use in
 source and binary forms, with or without modification, are permitted
 provided that the following conditions are met:

    * Redistributions of source code must retain the above
      copyright notice, this list of conditions and the following
      two paragraphs of disclaimer.
    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the following
      two paragraphs of disclaimer in the documentation and/or other materials
      provided with the distribution.
    * Neither the name of the Regents nor the names of its contributors
      may be used to endorse or promote products derived from this
      software without specific prior written permission.

 IN NO EVENT SHALL REGENTS BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
 SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
 ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 REGENTS HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 REGENTS SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT
 LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 A PARTICULAR PURPOSE. THE SOFTWARE AND ACCOMPANYING DOCUMENTATION, IF
 ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". REGENTS HAS NO OBLIGATION
 TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR
 MODIFICATIONS.
*/

package Chisel

import scala.collection.mutable.ArrayBuffer

object Clock {
  def apply(name: String): Clock = {
    clock_cache.getOrElseUpdate(name, new Clock(name))
  }

  private val clock_cache = scala.collection.mutable.Map[String,Clock]()
}

class Clock private (_name: String) extends Node {
  setName(_name)

  val stateElms = new ArrayBuffer[Node]
  init(name, 1)

  var srcClock: Clock = null
  var initStr = ""
/*
  // Removed temporarily until naming situation can be resolved
  def * (x: Int): Clock = {
    val clock = new Clock
    clock.init("", 1)
    clock.srcClock = this
    clock.initStr = " * " + x + ";\n"
    clock
  }

  def / (x: Int): Clock = {
    val clock = new Clock
    clock.init("", 1)
    clock.srcClock = this
    clock.initStr = " / " + x + ";\n"
    clock
  }
*/
}
