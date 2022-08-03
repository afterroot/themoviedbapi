/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.model

import com.fasterxml.jackson.annotation.JsonRootName
import info.movito.themoviedbapi.model.core.NamedIdElement

@Deprecated("Use New Genre", replaceWith = ReplaceWith("Genre", "com.afterroot.tmdbapi.model.Genre"))
@JsonRootName("genre")
class Genre : NamedIdElement()
