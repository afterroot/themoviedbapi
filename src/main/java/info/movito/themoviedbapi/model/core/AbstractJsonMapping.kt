package info.movito.themoviedbapi.model.core

import android.util.Log
import com.fasterxml.jackson.annotation.JsonAnySetter
import java.io.Serializable

/**
 * @author Holger Brandl
 */
abstract class AbstractJsonMapping : Serializable {
    @JsonAnySetter
    open fun handleUnknown(key: String?, value: Any?) {
        val unknown = "Unknown property: '$key'"
        val result = kotlin.runCatching {
            Log.d(TAG, "handleUnknown: $unknown")
        }
        if (result.isFailure) {
            println("handleUnknown: $unknown")
        }
    }

    companion object {
        private const val TAG = "AbstractJsonMapping"
    }

    // abstract fun type() : Int
}
