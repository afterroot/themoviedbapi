/*
 * Copyright (c) 2014, Holger Brandl
 * All rights reserved.
 */

package info.movito.themoviedbapi.tools;

public class RequestCountLimitException extends RuntimeException {

    /**
     * Retry internal in seconds.
     */
    private final int retryAfter;


    public RequestCountLimitException(String jsonResposne, int retryAfter) {
        super(jsonResposne);
        this.retryAfter = retryAfter;
    }


    public int getRetryAfter() {
        return retryAfter;
    }
}
